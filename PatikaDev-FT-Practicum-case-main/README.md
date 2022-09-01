# Patika-Dev-FT-Practicum-case
FT Teknoloji Java Spring Boot Practicum'ta verilen first-case için hazırlanmıştır.

## Kullanılan Teknolojiler
* Java8
* Maven
* Spring Boot (Version : 2.7.3)
* Postqresql
* Dependencies
==> Spring Web
-- Spring Boot DevTools
-- Lombok
-- Spring Data JPA

### Comment Controller

Method   |   Path   |   Description|Request Parameters
---------|----------|--------------|----------
GET      |/comments/byProductId/{productId}| Bir ürüne ait yorum listesini alır|integer($int64) (productId)
GET      |/comments/byUserId/{userId}| Bir kullanıcının yapmış olduğu yorum listesini alır|integer($int64) (userId)
GET      |/comments/byUserIdInDateRange/{userId}| Bir kullanıcın belirli tarihler arasında yapmış olduğu yorum listesini alır|integer($int64) (userId) string($date-time) <p/>  string($date-time)<p/>Date format: yyyy/MM/dd
GET      |/comments/byProductIdInDateRange/{productId}| Verilen tarih aralıklarında belirli bir ürüne yapılmış yorum listesini alır|integer($int64) (productId) string($date-time) <p/>  string($date-time)<p/>Date format: yyyy/MM/dd
POST     |/comments{userId}/{productId}| Birkullanıcının bir ürüne yapmış olduğu yorumu kaydeder|integer($int64) (userId) integer($int64) (productId) <p/> Comment(Json body)



### Product Controller

Method   |   Path   |   Description|Request Parameters
---------|----------|--------------|------------------
GET      |/products/expired| Son kullanma tarihi geçiş ürün listesini alır|No parameters
GET      |/products/notExpired| Son kullanma tarihi geçmemiş veya null olan ürünlerin listesini alır|No parameters
POST     |/products| Bir ürünü kaydeder|Product(Json body)

### Not :
- Son kullanma tarihi geçmemiş yada null olan ürünler için ProductRepository interface inde aşağıdaki query yazıldı.
```
@Query(value = "SELECT * FROM products p WHERE DATE(NOW()) < p.expiration_date OR p.expiration_date is null",
			nativeQuery = true)
	List<Product> findAllNotExpired();
``` 
- Son kullanma tarihi geçmiş ürünler için ProductRepository interface inde aşağıdaki query yazıldı.
```
@Query(value = "SELECT * FROM products p WHERE DATE(NOW()) >= p.expiration_date",
			nativeQuery = true)
	List<Product> findAllExpired();
```

### User Controller

Method   |   Path   |   Description|Request Parameters
---------|----------|--------------|------------------
POST     |/users| Bir kullanıcıyı kaydeder|User(Json body)
