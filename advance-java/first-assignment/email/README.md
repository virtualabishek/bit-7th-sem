# Java Mail API - Simple Version

Goal:
Send one simple email from Java using Gmail SMTP.

This code is intentionally minimal (like a quick nodemailer script):
- SMTP host, port, user, and password are loaded from environment variables
- Create a `.env` file at the repo root (see `.env.example`) or export the variables:
  - `SMTP_HOST`, `SMTP_PORT`, `SMTP_USER`, `SMTP_PASS`
- To email is fixed: abi@abishekn.com.np
- Subject and body are fixed in code

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
- Password is no longer hardcoded — it's loaded from `SMTP_PASS` environment variable.
- Create a `.env` file in the repo root with your SMTP credentials (see `.env.example`).
- If abi address is different, change the toEmail value in EmailSender.java.
