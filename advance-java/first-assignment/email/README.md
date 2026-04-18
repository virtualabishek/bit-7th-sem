# Java Mail API - Simple Version

Goal:
Send one simple email from Java using Gmail SMTP.

This code is intentionally minimal (like a quick nodemailer script):
- SMTP host is fixed: smtp.gmail.com
- SMTP port is fixed: 465
- From email is fixed: codewithabishek@gmail.com
- To email is fixed: abi@abishekn.com.np
- Subject and body are fixed in code
- Password is fixed in code for quick testing

Files:
- pom.xml
- src/main/java/EmailSender.java

How to run:

1. Open terminal in this folder:
cd ~/Desktop/bit-7th-sem/advance-java/first-assignment/email

2. Compile:
mvn -q compile

3. Run:
mvn -q exec:java

If successful, you will see:
Email sent successfully to: abi@abishekn.com.np

Nodemailer to JavaMail mapping:
- nodemailer host -> mail.smtp.host
- nodemailer port -> mail.smtp.port
- nodemailer secure: true -> mail.smtp.ssl.enable = true
- nodemailer auth user/pass -> Authenticator with PasswordAuthentication
- transporter.sendMail(...) -> Transport.send(message)

Important note:
- For test only, password is currently hardcoded in EmailSender.java.
- After testing, remove hardcoded password and keep it in environment variable.
- If abi address is different, change the toEmail value in EmailSender.java.
