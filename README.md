# FinDash 💰

A full-stack personal finance dashboard that connects to your bank accounts, tracks spending, and visualizes your financial health — built as a portfolio project to demonstrate end-to-end full-stack engineering.

## Overview

FinDash lets users securely link their bank accounts (via Plaid), automatically syncs and categorizes transactions, tracks budgets, and surfaces spending insights through an interactive dashboard.

## Tech Stack

**Backend**
- Java 17/21, Spring Boot 3.x
- Spring Data JPA / Hibernate
- Spring Security + JWT
- PostgreSQL

**Frontend**
- React + TypeScript
- Vite
- Axios
- React Router

**Integrations**
- [Plaid API](https://plaid.com/) — secure bank account linking & transaction sync

## Project Status

🚧 **In active development.** Built solo, following a self-adapted Agile process (1-week sprints, 7 epics).

| Epic | Status |
|---|---|
| A — Foundation (backend/frontend scaffolding, DB connection) | ✅ Done |
| B — Auth & Users | 🔜 In progress |
| C — Plaid Integration | ⬜ Planned |
| D — Transactions & Accounts | ⬜ Planned |
| E — Categorization & Budgets | ⬜ Planned |
| F — Dashboards & Insights | ⬜ Planned |
| G — Polish & Hardening | ⬜ Planned |

## Features (planned)

- 🔐 Secure user authentication (JWT-based)
- 🏦 Bank account linking via Plaid
- 💳 Automatic transaction sync & categorization
- 📊 Budget tracking with spend-vs-budget insights
- 📈 Net worth tracking over time
- 🔁 Recurring transaction / subscription detection

## Architecture

```
React (TypeScript) ── Axios ──> Spring Boot REST API ──> PostgreSQL
                                        │
                                        └──> Plaid API (bank sync)
```

## Getting Started

### Prerequisites
- Java 17+
- Node.js 18+
- PostgreSQL 15+ (running locally)

### Backend
```bash
cd findash-backend
./mvnw spring-boot:run     # macOS/Linux
.\mvnw.cmd spring-boot:run # Windows
```
Runs on `http://localhost:8080`. Configure your local Postgres connection in `src/main/resources/application.yml`.

### Frontend
```bash
cd findash-frontend
npm install
npm run dev
```
Runs on `http://localhost:5173`.

## Roadmap

See the [project board](../../projects) for the full sprint-by-sprint plan.

## License

MIT