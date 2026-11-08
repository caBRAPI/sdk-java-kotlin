# Security

The security of this SDK is treated as a priority. If you identify a vulnerability, we appreciate its responsible disclosure so that we can investigate and fix the issue quickly.

## Reporting a vulnerability

Send the details through one of the channels below:

* Send an email to the responsible department `suporte@cabrapi.com.br` 

* Or send an email directly to the responsible developer `sebastianjnuwu@gmail.com`.

## Important information in the report

Whenever possible, include:

* Affected SDK version
  Example: `1.0.0`

* Environment used
  Example: Java 17, Java 21, Minecraft Spigot/Paper, Maven, Gradle

* Detailed steps to reproduce the issue

* Expected behavior and observed behavior

* Logs, stack traces, and proofs of concept (PoC)

* Potential impact of the vulnerability

## Response process

We commit to following a responsible disclosure process:

1. We acknowledge receipt of the report within **72 hours**
2. We investigate the issue and assess the impact
3. When necessary, we develop a fix and publish a new version
4. We issue a security advisory and CVE (when applicable)
5. The report author will be notified before public disclosure

## Responsible disclosure policy

To protect the project's users:

* Do not publicly disclose technical details of the vulnerability before the official fix
* Avoid publishing exploits, PoCs, or reproduction methods in public Issues
* Wait for the patch and security advisory to be released

## Security recommendations

To reduce risks in production:

* Always use the most recent version of the SDK
* Keep your runtimes updated
  Recommended: `Java >= 8`
* Never expose private keys in the client
* Store secrets using secure environment variables
* Implement appropriate validation and authentication on the server

We appreciate your collaboration in keeping the ecosystem safer for everyone.
