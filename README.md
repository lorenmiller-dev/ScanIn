<a id="readme-top"></a>

<br />
<div align="center">
  <h3 align="center">NFC Member Tap Access System</h3>

  <p align="center">
    A scalable NFC-based member tap system that allows registered users to authenticate by tapping their phone using Express NFC mode — inspired by transit systems like Suica.
    <br />
    <br />
    <a href="https://github.com/your_username/your_repo">View Demo</a>
    ·
    <a href="https://github.com/your_username/your_repo/issues">Report Bug</a>
    ·
    <a href="https://github.com/your_username/your_repo/issues">Request Feature</a>
  </p>
</div>

---

## About The Project

This project simulates a real-world NFC-based tap authentication system similar to transit platforms like Suica.

The system allows registered members to tap their NFC-enabled mobile device in Express mode to:

- Authenticate identity
- Validate membership status
- Log entry events
- Return limited member profile data
- Support scalable API integration

The architecture is designed to reflect production-grade backend systems used in:

- Transit systems
- Warehouse entry systems
- Membership clubs
- Corporate access control

This project emphasizes secure API design, scalable database architecture, and low-latency member lookup.

---

## Architecture Overview

```xml
NFC Scanner Device
↓
REST API (Stateless)
↓
Redis Cache (Hot Member Lookups)
↓
PostgreSQL (Source of Truth)
↓
Scan Event Logging
```

### Key Design Principles

- Stateless API for horizontal scalability
- PostgreSQL as authoritative member registry
- Indexed NFC token ID for fast lookup
- Redis cache to reduce DB load during peak tap times
- Secure API authentication between scanner and backend

---

## Built With

- Java + Spring Boot
- PostgreSQL
- Redis
- Docker
- RESTful API Design
- OpenAPI / Swagger

---

## Database Design

### Members Table

- id 
- nfc_token_id
- first_name
- last_name
- membership_status
- membership_tier
- created_at

### Tap_Logs Table

- id
- member_id 
- scanner_id
- timestamp
- result (SUCCESS / DENIED)

---

## API Endpoints

### POST /tap

Processes an NFC tap event.

**Request**
```json
{
  "nfc_token_id": "A1B2C3D4",
  "scanner_id": "ENTRANCE_01"
}

Response

{
  "name": "John Smith",
  "membership_tier": "Gold",
  "status": "Active"
}
