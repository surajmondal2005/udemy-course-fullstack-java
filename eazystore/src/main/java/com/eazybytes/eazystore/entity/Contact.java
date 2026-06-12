package com.eazybytes.eazystore.entity;

@lombok.Getter
@lombok.Setter@jakarta.persistence.Entity
@jakarta.persistence.Table(name = "contacts")
public class Contact {
@jakarta.persistence.Id
@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
@jakarta.persistence.Column(name = "contact_id", nullable = false)
private java.lang.Long id;

@jakarta.persistence.Column(name = "name", nullable = false, length = 100)
private java.lang.String name;

@jakarta.persistence.Column(name = "email", nullable = false, length = 100)
private java.lang.String email;

@jakarta.persistence.Column(name = "mobile_number", nullable = false, length = 15)
private java.lang.String mobileNumber;

@jakarta.persistence.Column(name = "message", nullable = false, length = 500)
private java.lang.String message;

@org.hibernate.annotations.ColumnDefault("CURRENT_TIMESTAMP")
@jakarta.persistence.Column(name = "created_at", nullable = false)
private java.time.Instant createdAt;

@jakarta.persistence.Column(name = "created_by", nullable = false, length = 20)
private java.lang.String createdBy;

@jakarta.persistence.Column(name = "updated_at")
private java.time.Instant updatedAt;

@jakarta.persistence.Column(name = "updated_by", length = 20)
private java.lang.String updatedBy;



}