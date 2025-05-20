# Ürün Yönetim Sistemi

Bu proje, Spring Boot kullanılarak geliştirilmiş bir basit ürün yönetim API'sidir.  
Frontend tarafında saf HTML ve JavaScript ile ürünler listelenmektedir.

## Kullanılan Teknolojiler

- Java 17+
- Spring Boot 3.x
- PostgreSQL
- HTML + JavaScript (Fetch API)
- Postman (API testleri için)


## Nasıl Çalıştırılır?

### Backend (Spring Boot)

```bash
# IntelliJ' de projeyi aç
# PostgreSQL veritabanını ayarla ve application.properties dosyasına bilgileri gir
# Ardından projeyi başlat (port 8080'de çalışır)
```

Örnek: `http://localhost:8080/api/products`

### Frontend (HTML)

```bash
# Terminalde HTML dosyasının bulunduğu dizine git:
cd path/to/project

# Basit HTTP server başlat:
python3 -m http.server 3000


Tarayıcıda aç:  
`http://localhost:3000/index.html`


## Özellikler

- Ürünleri listele (HTML'de)
- Spring Boot API: ürünleri ekle, sil, getir
- CORS ayarları sayesinde frontend-backend bağlantısı kuruldu
- Postman ile tüm endpoint'ler test edildi


## API Endpoint'leri

| Method | URL                        | Açıklama               |

| GET    | `/api/products`            | Tüm ürünleri getir     |
| POST   | `/api/products`            | Yeni ürün ekle         |
| GET    | `/api/products/{id}`       | ID ile ürün getir      |
| DELETE | `/api/products/{id}`       | Ürün sil               |


## Postman Testleri

Tüm API endpoint'leri Postman ile test edilmiştir.  
Dilersen `postman_collection.json` dosyasını yükleyip kullanabilirsin. 


## Proje Yapısı

logiwa-product-api/
│
├── src/main/java/com/logiwa/productapi/
│   ├── controller/
│   ├── model/
│   ├── repository/
│   └── service/
│
├── src/main/resources/
│   └── application.properties
│
├── index.html
└── README.md


## 👤 Geliştirici

- Ad Soyad: Nevroz Aslan
- E-posta: as.nevroz@gmail.com
