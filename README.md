# caffeine cache


### description
로컬 캐시중의 하나인 caffeine cache 적용 한 sample project.

## Ehcache와 Caffeine Cache 비교

### 1. 성능 비교
| **기능**                | **Ehcache**                    | **Caffeine**                                |
|-------------------------|--------------------------------|--------------------------------------------|
| **캐시 적중률**         | 평균 수준                     | 매우 높음 (W-TinyLFU 알고리즘)              |
| **디스크 기반 캐싱**    | 지원                         | 지원하지 않음 (메모리 캐싱 전용)           |
| **비동기 로딩**         | 제한적 지원                   | 완전한 지원                                |
| **사용자 정의 만료 정책**| 제한적                        | 고급 만료 정책 지원                        |
| **통합성 (Spring 등)**  | 잘 통합됨                     | Spring Boot와 완벽 통합                    |
| **GC 성능**             | 객체 참조를 계속 유지         | 객체 약한 참조 사용, GC 부담 적음           |

---

### 2. 캐시 만료 정책
- **Ehcache**:
  - 단순한 만료 정책(예: Time-to-Live, Time-to-Idle)을 지원.
  - 사용자 정의 만료 정책 구현이 어렵고 복잡.

- **Caffeine**:
  - 시간 기반 만료(Time-based eviction), 크기 기반 만료(Size-based eviction)를 기본 제공.
  - **액세스 빈도와 재참조**를 고려한 고급 만료 정책 지원.

---

### 3. Ehcache vs Caffeine Cache 장단점

### Ehcache의 장점
- **디스크 기반 캐싱**을 지원하여 영속성이 필요한 애플리케이션에 적합.
- 오래된 레거시 시스템과의 호환성.

### Caffeine Cache의 장점
- **W-TinyLFU 알고리즘**으로 캐시 적중률 극대화.
- 최신 JVM 아키텍처 최적화.
- **Spring Boot와의 통합**이 간단하며, 설정과 사용법이 직관적.
- 성능 최적화가 필요한 API 서비스에 적합.

---

## 4. Cacheable과 CacheEvict의 차이

### @Cacheable
- **기능**:
  - 메서드 실행 결과를 캐시에 저장.
  - 동일한 입력값으로 호출 시, 캐시에 저장된 값을 반환하여 메서드 실행을 방지.

- **사용 예**:
  ```java
  @Cacheable(value = "books", key = "#isbn")
  public Book getBookByIsbn(String isbn) {
      return bookRepository.findByIsbn(isbn);
  }

LIRS (Low Inter-reference Recency Set), LRU 등의 알고리즘보다 효율적.

### 링크 참고
* [Caffeine Cache Github](https://github.com/ben-manes/caffeine)