Read [](file:///home/virtualabishek/Desktop/bit-7th-sem/advance-java/unit-2-swing-java/AWTBasic.java)

Perfect! I can see your code. Let me explain `.setBounds()`:

`.setBounds(x, y, width, height)` has 4 values:

1. **x** (first value): How far from the LEFT edge of the frame (in pixels)
2. **y** (second value): How far from the TOP edge of the frame (in pixels)
3. **width** (third value): How WIDE the component is (in pixels)
4. **height** (fourth value): How TALL the component is (in pixels)

Visual example from your code:
```
name.setBounds(50, 100, 50, 20);
                └─  └─   └─  └─
                │   │    │   └── HEIGHT = 20 pixels tall
                │   │    └─────── WIDTH = 50 pixels wide
                │   └──────────── Y position = 100 pixels down from top
                └─────────────── X position = 50 pixels from left
```

So the "Name" label appears at position (50, 100) and takes up 50×20 pixels.

What if you set them all the same?
```java
name.setBounds(100, 100, 100, 100);  // square, offset from top-left
name.setBounds(0, 0, 100, 100);      // square, at the very top-left corner
name.setBounds(100, 100, 100, 100);  // same x and y = square shape, positioned at (100,100)
```

Key point: x and y control **position**, width and height control **size**. You CAN set x=y if you want, but width should match height only if you want a square.

Full coordinate system:
```
(0,0) ──────────────────────── (500,0)
  │                              │
  │  (50,100)                     │
  │     ↓                         │
  │  ┌──────┐                     │
  │  │ Name │ width=50, height=20 │
  │  └──────┘                     │
  │                              │
(0,500) ───────────────────── (500,500)
```

In your form:
- "Name" label at (50, 100), size 50×20
- "Name" textfield at (150, 100), size 150×20 ← moved 100 pixels RIGHT, same Y and height
- "Address" label at (50, 150), size 50×20 ← moved 50 pixels DOWN, same X and width
- Submit button at (250, 200), size 50×30 ← bigger height for button

Pro tip: Always set `frame.setLayout(null)` before using `setBounds()`, otherwise layout manager ignores it.