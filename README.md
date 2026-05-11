# CodeForge AI 🤖

> An AI-powered coding agent that lives in your terminal.

CodeForge is a command-line tool built with **Java + Spring Boot** that brings an AI agent directly into your development workflow. Ask it to explain code, read files, or just chat with it about your codebase — all without leaving the terminal.

## Features

- 🧠 **AI-powered** — understands and explains your code
- 📂 **File-aware** — reads and analyzes files from your local machine
- ⚡ **Fast** — runs as a native CLI command from anywhere

## Commands

| Command | Description | Example |
|---|---|---|
| `explain <file>` | Explains what a code file does | `codeforge explain UserService.java` |
| `read <file>` | Reads and analyzes a file | `codeforge read D:/project/pom.xml` |
| `help` | Shows available commands | `codeforge help` |

---

## Installation

### Prerequisites

- Java 17+ installed
- Maven installed
- Git

### Clone & Build

```bash
git clone https://github.com/yourusername/CodeForgeAI.git
cd CodeForgeAI
mvn clean package -DskipTests
```

This produces the JAR at:
```
target/CodeForgeAI.jar
```

---

## Setup on Windows

### 1. Build the JAR

```cmd
cd D:\CodeForgeAI
mvn clean package -DskipTests
```

### 2. Create the launcher script

Create a file called `codeforge.bat` anywhere you like, for example `C:\tools\codeforge\codeforge.bat`:

```bat
@echo off
java -jar D:\CodeForgeAI\target\CodeForgeAI.jar %*
```

> Update the path to match where your JAR lives.

### 3. Add to PATH

1. Press `Win + S` and search **"Environment Variables"**
2. Click **"Edit the system environment variables"**
3. Click **"Environment Variables"**
4. Under **System variables**, find **Path** → click **Edit**
5. Click **New** → enter the folder containing your `.bat` file (e.g. `C:\tools\codeforge`)
6. Click **OK** on all dialogs
7. **Restart your terminal**

### 4. Run it

```cmd
codeforge help
codeforge explain src/main/java/App.java
```

### Optional: Rebuild script

Create `rebuild.bat` in the same folder as `codeforge.bat`:

```bat
@echo off
cd D:\CodeForgeAI
mvn clean package -DskipTests
echo.
echo Build done! JAR is ready.
```

Now you can just run `rebuild` after any code change.

---

## Setup on macOS / Linux

### 1. Build the JAR

```bash
cd ~/CodeForgeAI
mvn clean package -DskipTests
```

### 2. Create the launcher script

```bash
sudo nano /usr/local/bin/codeforge
```

Paste this:

```bash
#!/bin/bash
java -jar ~/CodeForgeAI/target/CodeForgeAI.jar "$@"
```

> Update the path to match where your JAR lives.

### 3. Make it executable

```bash
sudo chmod +x /usr/local/bin/codeforge
```

`/usr/local/bin` is already in PATH on most systems, so no further setup is needed.

### 4. Run it

```bash
codeforge help
codeforge explain src/main/java/App.java
```

### Optional: Rebuild script

Create a `rebuild.sh` in your project root:

```bash
#!/bin/bash
cd ~/CodeForgeAI
mvn clean package -DskipTests
echo ""
echo "Build done! JAR is ready."
```

Make it executable:

```bash
chmod +x rebuild.sh
```

Run after code changes:

```bash
./rebuild.sh
```

Or move it to `/usr/local/bin/codeforge-rebuild` to run it from anywhere:

```bash
sudo cp rebuild.sh /usr/local/bin/codeforge-rebuild
sudo chmod +x /usr/local/bin/codeforge-rebuild
```

---

## Project Structure

```
CodeForgeAI/
├── src/
│   └── main/
│       └── java/com/CodeForge/aI/CodeForgeAI/
│           ├── cli/
│           │   ├── CodeForgeCli.java      
│           │   └── CommandRouter.java      
│           └── service/
│               └── AIService.java        
├── src/main/resources/
│   └── application.yaml                    
├── pom.xml
└── README.md
```
---

## Built With

- [Java 17+](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)

---

## License

MIT License — feel free to use, fork, and build on top of CodeForge.
