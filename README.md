# BudgetMate - Backend

Spring Boot 기반의 **1인 가구 맞춤형 가계부 자동화 서비스** 백앤드입니다다.  
영수증 OCR, 소비 통계 분석, 저지출 챌린지 기능을 제공합니다.

---

# 주요 기능

- ✅ 사용자 회원가입 / 로그인 (JWT 기반 인증)
- ✅ OCR 기반 영수증 업로드 및 항목 자동 분류
- ✅ 소비 통계 분석 ( 주별, 카테고리별)
- ✅ 무지출 챌린지 참여 및 리워드 시스템

---

# 기술 스택

| 항목        | 사용 기술 |
|-------------|-----------|
| Language    | Java 21 |
| Framework   | Spring Boot 3.x, Spring Data JPA |
| DB          | MySQL |
| Infra       | Docker, GitHub |
| 빌드 도구    | Maven |
| 기타        | JWT, Lombok |

---

# 패키지 구조
org.budgetmate
├── user # 사용자 인증 및 관리
├── receipt # 영수증 업로드, 분석, 저장
├── challenge # 저지출 챌린지 및 리워드
├── analysis # 소비 데이터 통계 분석
└── common # JWT, 예외 처리, 공통 응답 등

---

# 팀원 역할

| 이름   | 역할 설명 |
|--------|----------|
| 김현수 | 사용자 인증 / 로그인, 영수증 처리, DB 설계 및 API 구현 |
| 유경아 | 소비 통계 분석, 챌린지 기능, 프론트 UI 설계 및 연동 |

---

# 추후 계획

- 📌 프론트엔드(React)와 API 연동
- ☁️ Spring Cloud 기반의 MSA 구조 전환
- 🐳 Docker 기반 실행 환경 구성 예정
- 🚀 AWS 배포 및 CI/CD 구축
