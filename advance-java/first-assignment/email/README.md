# Java Mail API (SMTP) - Assignment Solution

## Requirement
Send an email using Java Mail API with SMTP configuration.

This implementation uses Gmail SMTP:
- Host: smtp.gmail.com
- Port: 465
- SSL: enabled
- Authentication: enabled

## Project Files
- `pom.xml`
- `src/main/java/EmailSender.java`

## How to Run

1. Go to project folder:
```bash
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/email
```

2. Set environment variables:
```bash
export SMTP_HOST="smtp.gmail.com"
export SMTP_PORT="465"
export SMTP_USER="codewithabishek@gmail.com"
export SMTP_PASS="YOUR_APP_PASSWORD"
```

3. Compile:
```bash
mvn -q compile
```

4. Run:
```bash
mvn -q exec:java -Dexec.args="receiver@example.com \"SMTP Test\" \"Hello from Java Mail API\""
```

## Example
To send to yourself:
```bash
mvn -q exec:java -Dexec.args="codewithabishek@gmail.com \"Test\" \"Hello Abishek\""
```

## Notes
- Use Gmail App Password in `SMTP_PASS`.
- Do not store `SMTP_PASS` in source code.
- If authentication fails, recheck app password and sender account settings.
