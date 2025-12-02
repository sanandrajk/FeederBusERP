# CI/CD GitHub Actions for FeederBusERP

This repository includes a GitHub Actions workflow at `.github/workflows/ci-cd.yml` that:

- Runs tests using Maven and TestNG
- Installs Playwright browsers (via the Playwright Java CLI)
- Packages the application
- On push to `main` or when a tag is pushed, builds and pushes a Docker image to GitHub Container Registry (GHCR)
- On tag pushes, attaches the built JAR to a GitHub Release

## How to use

1. The workflow runs for pushes and pull requests automatically.
2. To enable images publishing, the workflow uses the `GITHUB_TOKEN` by default to authenticate with GHCR. The `GITHUB_TOKEN` is provided by GitHub Actions and should work for publishing to `ghcr.io/${{ github.repository }}` with `packages: write` permissions.

### Secrets (optional)

- `GITHUB_TOKEN` (this is provided by GitHub automatically)
- If you want to push to Docker Hub instead of GHCR, create and add `DOCKERHUB_USERNAME` and `DOCKERHUB_TOKEN` in GitHub repository secrets and update the `publish` job accordingly.

### Dockerfile

A sample `Dockerfile.example` is included; copy or rename it to `Dockerfile` and adjust `JAR_FILE` if your artifact name differs.

### Playwright Browsers

The workflow calls `mvn -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install" exec:java` to install the Playwright browsers used during UI tests. If you prefer to control browser installation differently (for example, caching the browser downloads), modify or add a cache entry for the Playwright cache dir.

## Notes & Tips

- If you add additional Java versions to the matrix, they will run in separate jobs.
- If your tests need a headless mode, make sure code uses `setHeadless(true)` in your `Playwright` setup; CI environments normally run headless.
- Ensure `testng.xml` includes all test suites or adjust the `mvn` test step if needed.
- If you want to run steps in Windows or Mac, add runners `runs-on: windows-latest` or `macos-latest` as desired.

---

If you'd like, I can also:
- Add a job to run code analysis (SpotBugs, Checkstyle)
- Add GitHub Pages deployment for a docs site
- Add a conditional to skip UI Playwright tests in certain contexts to speed up PRs
