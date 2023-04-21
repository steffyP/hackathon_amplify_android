package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Product type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Products", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Product implements Model {
  public static final QueryField ID = field("Product", "id");
  public static final QueryField NAME = field("Product", "name");
  public static final QueryField EXPIRATION_DATE = field("Product", "expiration_date");
  public static final QueryField TYPE = field("Product", "type");
  public static final QueryField CONTENT = field("Product", "content");
  public static final QueryField CONTENT_TYPE = field("Product", "content_type");
  public static final QueryField PHOTO_S3 = field("Product", "photo_s3");
  public static final QueryField AMOUNT = field("Product", "amount");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="AWSDate") Temporal.Date expiration_date;
  private final @ModelField(targetType="ProductType") ProductType type;
  private final @ModelField(targetType="Int") Integer content;
  private final @ModelField(targetType="ContentType") ContentType content_type;
  private final @ModelField(targetType="String") String photo_s3;
  private final @ModelField(targetType="Int") Integer amount;
  private final @ModelField(targetType="ReceipeProduct") @HasMany(associatedWith = "product", type = ReceipeProduct.class) List<ReceipeProduct> receipes = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public Temporal.Date getExpirationDate() {
      return expiration_date;
  }
  
  public ProductType getType() {
      return type;
  }
  
  public Integer getContent() {
      return content;
  }
  
  public ContentType getContentType() {
      return content_type;
  }
  
  public String getPhotoS3() {
      return photo_s3;
  }
  
  public Integer getAmount() {
      return amount;
  }
  
  public List<ReceipeProduct> getReceipes() {
      return receipes;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Product(String id, String name, Temporal.Date expiration_date, ProductType type, Integer content, ContentType content_type, String photo_s3, Integer amount) {
    this.id = id;
    this.name = name;
    this.expiration_date = expiration_date;
    this.type = type;
    this.content = content;
    this.content_type = content_type;
    this.photo_s3 = photo_s3;
    this.amount = amount;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Product product = (Product) obj;
      return ObjectsCompat.equals(getId(), product.getId()) &&
              ObjectsCompat.equals(getName(), product.getName()) &&
              ObjectsCompat.equals(getExpirationDate(), product.getExpirationDate()) &&
              ObjectsCompat.equals(getType(), product.getType()) &&
              ObjectsCompat.equals(getContent(), product.getContent()) &&
              ObjectsCompat.equals(getContentType(), product.getContentType()) &&
              ObjectsCompat.equals(getPhotoS3(), product.getPhotoS3()) &&
              ObjectsCompat.equals(getAmount(), product.getAmount()) &&
              ObjectsCompat.equals(getCreatedAt(), product.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), product.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getExpirationDate())
      .append(getType())
      .append(getContent())
      .append(getContentType())
      .append(getPhotoS3())
      .append(getAmount())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Product {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("expiration_date=" + String.valueOf(getExpirationDate()) + ", ")
      .append("type=" + String.valueOf(getType()) + ", ")
      .append("content=" + String.valueOf(getContent()) + ", ")
      .append("content_type=" + String.valueOf(getContentType()) + ", ")
      .append("photo_s3=" + String.valueOf(getPhotoS3()) + ", ")
      .append("amount=" + String.valueOf(getAmount()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Product justId(String id) {
    return new Product(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      expiration_date,
      type,
      content,
      content_type,
      photo_s3,
      amount);
  }
  public interface BuildStep {
    Product build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep expirationDate(Temporal.Date expirationDate);
    BuildStep type(ProductType type);
    BuildStep content(Integer content);
    BuildStep contentType(ContentType contentType);
    BuildStep photoS3(String photoS3);
    BuildStep amount(Integer amount);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private Temporal.Date expiration_date;
    private ProductType type;
    private Integer content;
    private ContentType content_type;
    private String photo_s3;
    private Integer amount;
    @Override
     public Product build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Product(
          id,
          name,
          expiration_date,
          type,
          content,
          content_type,
          photo_s3,
          amount);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep expirationDate(Temporal.Date expirationDate) {
        this.expiration_date = expirationDate;
        return this;
    }
    
    @Override
     public BuildStep type(ProductType type) {
        this.type = type;
        return this;
    }
    
    @Override
     public BuildStep content(Integer content) {
        this.content = content;
        return this;
    }
    
    @Override
     public BuildStep contentType(ContentType contentType) {
        this.content_type = contentType;
        return this;
    }
    
    @Override
     public BuildStep photoS3(String photoS3) {
        this.photo_s3 = photoS3;
        return this;
    }
    
    @Override
     public BuildStep amount(Integer amount) {
        this.amount = amount;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, Temporal.Date expirationDate, ProductType type, Integer content, ContentType contentType, String photoS3, Integer amount) {
      super.id(id);
      super.name(name)
        .expirationDate(expirationDate)
        .type(type)
        .content(content)
        .contentType(contentType)
        .photoS3(photoS3)
        .amount(amount);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder expirationDate(Temporal.Date expirationDate) {
      return (CopyOfBuilder) super.expirationDate(expirationDate);
    }
    
    @Override
     public CopyOfBuilder type(ProductType type) {
      return (CopyOfBuilder) super.type(type);
    }
    
    @Override
     public CopyOfBuilder content(Integer content) {
      return (CopyOfBuilder) super.content(content);
    }
    
    @Override
     public CopyOfBuilder contentType(ContentType contentType) {
      return (CopyOfBuilder) super.contentType(contentType);
    }
    
    @Override
     public CopyOfBuilder photoS3(String photoS3) {
      return (CopyOfBuilder) super.photoS3(photoS3);
    }
    
    @Override
     public CopyOfBuilder amount(Integer amount) {
      return (CopyOfBuilder) super.amount(amount);
    }
  }
  
}
