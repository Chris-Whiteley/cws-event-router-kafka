# CWS Event Router Kafka

A Kafka implementation for the cws-event-router library.

## Repository Information
- GitHub Repository: [Chris-Whiteley/cws-event-router-kafka](https://github.com/Chris-Whiteley/cws-event-router-kafka)
- Dependencies Repository: [Chris-Whiteley/cws-event-router](https://github.com/Chris-Whiteley/cws-event-router)

## Project Setup

### Prerequisites

- Java 21
- Maven
- GitHub account (for package access)

### Authentication Setup

This project depends on private artifacts published to GitHub Packages:

- com.cwsoft:cws-event-router

- com.cwsoft:cws-kafka-messaging

Public dependencies (e.g. Apache Kafka, SLF4J) are resolved from Maven Central and do not require authentication.

If the above GitHub Packages are private, authentication is required.

🔑 GitHub Packages Authentication (if required)
1. **Create a GitHub Personal Access Token (PAT)**
    - Go to GitHub → Settings
    - Developer Settings → Personal Access Tokens
    - Click "Generate new token" (classic)
    - Select at least the `read:packages` scope
    - Copy the generated token

2. **Configure Maven Authentication**

   Add the following to your `~/.m2/settings.xml` file (create it if it doesn't exist):

   ```xml
   <settings>
     <servers>
       <server>
         <id>github</id>
         <username>Chris-Whiteley</username>
         <password>YOUR_PERSONAL_ACCESS_TOKEN</password>
       </server>
     </servers>
   </settings>
   ```

   Replace:
   - `YOUR_PERSONAL_ACCESS_TOKEN` with the token you generated

   **Optional: Environment variables (CI-friendly)** If you prefer environment variables (e.g. for CI):
   ```bash
   export GITHUB_TOKEN=your_token
   ```

   And reference it from settings.xml:
   ```bash
   <password>${env.GITHUB_TOKEN}</password>
   ```

### Dependencies

This project depends on:
- cws-event-router (1.0.0)
- cws-kafka-messaging (1.0.1)
- Apache Kafka Clients (3.9.0)
- Apache Kafka Streams (3.9.0)
- Project Lombok
- SLF4J

### Building the Project
```bash
  mvn clean install
```
To publish the artifact (maintainers only):
```bash
  mvn clean deploy
```