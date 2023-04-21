package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ReceipeProduct type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ReceipeProducts", type = Model.Type.USER, version = 1)
@Index(name = "byReceipe", fields = {"receipeId"})
@Index(name = "byProduct", fields = {"productId"})
public final class ReceipeProduct implements Model {
  public static final QueryField ID = field("ReceipeProduct", "id");
  public static final QueryField RECEIPE = field("ReceipeProduct", "receipeId");
  public static final QueryField PRODUCT = field("ReceipeProduct", "productId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Receipe", isRequired = true) @BelongsTo(targetName = "receipeId", targetNames = {"receipeId"}, type = Receipe.class) Receipe receipe;
  private final @ModelField(targetType="Product", isRequired = true) @BelongsTo(targetName = "productId", targetNames = {"productId"}, type = Product.class) Product product;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public Receipe getReceipe() {
      return receipe;
  }
  
  public Product getProduct() {
      return product;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ReceipeProduct(String id, Receipe receipe, Product product) {
    this.id = id;
    this.receipe = receipe;
    this.product = product;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ReceipeProduct receipeProduct = (ReceipeProduct) obj;
      return ObjectsCompat.equals(getId(), receipeProduct.getId()) &&
              ObjectsCompat.equals(getReceipe(), receipeProduct.getReceipe()) &&
              ObjectsCompat.equals(getProduct(), receipeProduct.getProduct()) &&
              ObjectsCompat.equals(getCreatedAt(), receipeProduct.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), receipeProduct.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getReceipe())
      .append(getProduct())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ReceipeProduct {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("receipe=" + String.valueOf(getReceipe()) + ", ")
      .append("product=" + String.valueOf(getProduct()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static ReceipeStep builder() {
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
  public static ReceipeProduct justId(String id) {
    return new ReceipeProduct(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      receipe,
      product);
  }
  public interface ReceipeStep {
    ProductStep receipe(Receipe receipe);
  }
  

  public interface ProductStep {
    BuildStep product(Product product);
  }
  

  public interface BuildStep {
    ReceipeProduct build();
    BuildStep id(String id);
  }
  

  public static class Builder implements ReceipeStep, ProductStep, BuildStep {
    private String id;
    private Receipe receipe;
    private Product product;
    @Override
     public ReceipeProduct build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ReceipeProduct(
          id,
          receipe,
          product);
    }
    
    @Override
     public ProductStep receipe(Receipe receipe) {
        Objects.requireNonNull(receipe);
        this.receipe = receipe;
        return this;
    }
    
    @Override
     public BuildStep product(Product product) {
        Objects.requireNonNull(product);
        this.product = product;
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
    private CopyOfBuilder(String id, Receipe receipe, Product product) {
      super.id(id);
      super.receipe(receipe)
        .product(product);
    }
    
    @Override
     public CopyOfBuilder receipe(Receipe receipe) {
      return (CopyOfBuilder) super.receipe(receipe);
    }
    
    @Override
     public CopyOfBuilder product(Product product) {
      return (CopyOfBuilder) super.product(product);
    }
  }
  
}
