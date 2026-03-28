Method Overloading vs Method Overloading in Java
Aspect	Method Overloading	Method Overriding
Definition	Same method name, different parameters	Same method name, same parameters in parent-child classes
Compile Time	Resolved at compile time	Resolved at runtime
Parameters	Must differ in number or type	Must be the same
Return Type	Can be different	Must be same or covariant
Inheritance	Not required	Required (IS-A relationship)
Binding	Static binding	Dynamic binding
Private/Final Methods	Can be overloaded	Cannot be overridden
Purpose	Compile-time polymorphism	Runtime polymorphism
Example	add(int, int) and add(int, int, int)	toString() in child class overrides parent
Quick记忆点:
- Overloading = "Same name, different args" (think: load more options)
- Overriding = "Same signature, replace parent behavior" (think: override the original)
