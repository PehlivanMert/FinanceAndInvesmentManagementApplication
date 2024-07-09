
# Finans ve Yatırım Yönetim Uygulaması

## Proje Hakkında

Bu uygulama, kullanıcıların finansal portföylerini yönetmelerine, hisse senedi ve kripto para piyasalarını takip etmelerine, yatırım analizi yapmalarına ve raporlar oluşturmalarına olanak tanır. Ayrıca gerçek zamanlı piyasa verilerini sağlar ve kullanıcı bildirimleri ile uyarılar gönderir.

## Kullanılan Teknolojiler

### Backend

- Java 22
- Spring Boot 3.3.1
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security 6.1
  - Spring Boot Starter Validation
  - Spring Boot Starter Web
  - Spring Boot Starter Actuator
- Spring Security 6.1
- PostgreSQL
- Prometheus Micrometer
- Swagger (Springfox)
- Lombok
- Json Web Token (JJWT)
- Testcontainers
- JUnit 5

### DevOps ve Monitoring

- Docker
- Prometheus
- Grafana
- Zipkin

## Proje Kurulumu ve Çalıştırma

### Backend

1. Projeyi klonlayın:
   ```bash
   git clone <https://github.com/PehlivanMert/FinanceAndInvesmentManagementApplication.git>
   cd <FinanceAndInvesmentManagementApplication>
   ```

2. Gerekli bağımlılıkları yükleyin:
   ```bash
   mvn clean install
   ```

3. PostgreSQL veritabanını başlatın ve yapılandırın:
   ```bash
   docker-compose up -d
   ```

4. Uygulamayı çalıştırın:
   ```bash
   mvn spring-boot:run
   ```

## Proje Yapısı

### Backend

- `Kullanici`: Kullanıcı bilgileri ve işlemleri
- `Portfoy`: Portföy yönetimi
- `YatirimAraci`: Yatırım araçları takibi
- `Bildirim`: Bildirim gönderimi


## Katkıda Bulunma

Projeye katkıda bulunmak isterseniz, lütfen bir pull request oluşturun veya issue açın.

## Lisans

Bu proje MIT Lisansı altında lisanslanmıştır.


