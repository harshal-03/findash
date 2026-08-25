# FinDash — Personal Finance Dashboard: Agile Execution Plan (Solo Dev)

## 1. How Agile adapts for a team of one

Agile's value for a solo project isn't ceremony overhead — it's **forcing scope discipline and continuous shippable progress**. Adapted rules:

- **Sprints**: 1 week each (short enough to keep momentum, long enough to finish real slices)
- **No standups** (nothing to stand up for), but keep a **daily log** (3 bullet points: did / blocked / next) — 2 minutes, keeps you honest
- **Sprint planning**: every Monday, pick 3–5 backlog items you can realistically finish
- **Sprint review**: every Friday — demo to yourself (does it actually run end-to-end?), update backlog
- **Retro**: quick self-check — what slowed you down this week, adjust next sprint's scope
- **Definition of Done** for every ticket: code written + manually tested + committed + (once you have CI) tests passing

Tools: a simple **GitHub Projects board** (Backlog / In Progress / Done) is enough — no need for Jira overhead on a solo project.

---

## 2. Product Backlog (Epics → broken into stories)

### Epic A — Project Foundation
- Set up Spring Boot project (Gradle/Maven, base packages)
- Set up Postgres + Docker Compose (local dev DB)
- Set up React + TypeScript project (Vite)
- CI pipeline (GitHub Actions: build + test on push)

### Epic B — Auth & Users
- User entity + registration endpoint
- Login + JWT issuance
- Spring Security config (JWT filter, protected routes)
- Frontend: login/register pages, auth context, protected routes

### Epic C — Plaid Integration
- Plaid sandbox account + API keys
- Backend: Plaid Link token creation endpoint
- Frontend: Plaid Link widget integration
- Backend: exchange public token → access token, store encrypted
- Backend: initial account + transaction sync on link

### Epic D — Transactions & Accounts
- Account entity + sync from Plaid
- Transaction entity + sync from Plaid (idempotent upsert)
- Scheduled job: periodic re-sync
- Frontend: account list view, transaction list view (paginated/filterable)

### Epic E — Categorization & Budgets
- Category entity (default categories seeded)
- Auto-categorization rules (merchant name matching)
- Manual category override endpoint + UI
- Budget entity (per category, per month)
- Budget vs. actual comparison endpoint
- Frontend: budget setup UI, progress bars

### Epic F — Dashboards & Insights
- Monthly spending-by-category endpoint (aggregation query)
- Net worth over time endpoint
- Recurring transaction detection (basic heuristic)
- Frontend: dashboard page with Recharts (pie/bar/line charts)

### Epic G — Polish & Hardening
- Error handling + validation across all endpoints
- Loading/empty/error states on frontend
- Encrypt sensitive fields at rest (Plaid tokens)
- Rate limiting on API
- Basic OWASP API Top 10 pass
- README + setup docs

---

## 3. Suggested Sprint Sequence

| Sprint | Focus | Goal at end of sprint |
|---|---|---|
| 1 | Epic A | Backend + frontend skeletons run locally, DB connected |
| 2 | Epic B | Can register/login, JWT-protected endpoint works end-to-end |
| 3 | Epic C | Plaid sandbox linked, access token stored securely |
| 4 | Epic D (part 1) | Accounts + transactions synced and stored |
| 5 | Epic D (part 2) | Frontend shows real transaction/account data |
| 6 | Epic E | Categorization + budgets working, UI for both |
| 7 | Epic F | Dashboard charts live on real synced data |
| 8 | Epic G | Hardened, documented, demo-ready |

~8 weeks at a sustainable solo pace (adjust based on your available hours/week — this assumes roughly evenings/weekends level effort; full-time would compress to ~3–4 weeks).

---

## 4. Working Agreement With Yourself (keeps solo Agile honest)

- **Vertical slices, not layers**: each sprint should produce something that *runs end-to-end*, even if ugly — e.g., Sprint 2 should have a real working login, not just a backend endpoint with no UI.
- **Timebox exploration**: if stuck >2 hours on one problem (e.g., Plaid webhook quirks), commit what works, log it as a known issue, move on — revisit in retro.
- **Commit often**: small, working commits > big infrequent ones — makes it easy to bisect bugs later.
- **Write the README as you go**: forces clarity on what each part actually does, and you'll thank yourself later.
- **Resist scope creep**: if a "nice idea" comes up mid-sprint (recurring bill reminders, multi-currency, etc.), add it to backlog — don't build it now.

---

## 5. Immediate Next Step

Start Sprint 1: scaffold the Spring Boot backend (entities, project structure, Docker Compose for Postgres) and the React + TypeScript frontend skeleton, wired together with a basic health-check endpoint.

Ready to begin?
