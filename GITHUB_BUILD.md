# Build Orca Client on GitHub

You do NOT need Java or Gradle installed on your PC to build the JAR with this workflow.

## 1. Create a GitHub repository

Create a new repository, for example:

`OrcaClient-26.3`

A public repository is easiest for a first test.

## 2. Upload the project

Upload the contents of this folder to the repository.

Important: `.github/workflows/build.yml` must be present.

## 3. Start the build

Go to:

**Actions → Build Orca Client → Run workflow**

The workflow will:
- use Ubuntu
- install Temurin JDK 25
- use the project's Gradle setup
- run `gradlew build`
- upload the compiled JAR

## 4. Download the JAR

Open the completed workflow run.

At the bottom, under **Artifacts**, download:

`orca-client-26.3`

Extract the artifact ZIP. Your JAR will be inside.

## If a build fails

Open the failed workflow and copy the red error section. That error will show exactly which 26.3 dependency or source API needs fixing.
