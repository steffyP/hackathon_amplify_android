package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

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

/** This is an auto generated class representing the Receipe type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Receipes", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Receipe implements Model {
  public static final QueryField ID = field("Receipe", "id");
  public static final QueryField NAME = field("Receipe", "name");
  public static final QueryField INGREDIENTS = field("Receipe", "ingredients");
  public static final QueryField DESCRIPTION = field("Receipe", "description");
  public static final QueryField UNTITLEDFIELD = field("Receipe", "untitledfield");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="ReceipeProduct") @HasMany(associatedWith = "receipe", type = ReceipeProduct.class) List<ReceipeProduct> Products = null;
  private final @ModelField(targetType="String") String ingredients;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="String") String untitledfield;
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
  
  public List<ReceipeProduct> getProducts() {
      return Products;
  }
  
  public String getIngredients() {
      return ingredients;
  }
  
  public String getDescription() {
      return description;
  }
  
  public String getUntitledfield() {
      return untitledfield;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Receipe(String id, String name, String ingredients, String description, String untitledfield) {
    this.id = id;
    this.name = name;
    this.ingredients = ingredients;
    this.description = description;
    this.untitledfield = untitledfield;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Receipe receipe = (Receipe) obj;
      return ObjectsCompat.equals(getId(), receipe.getId()) &&
              ObjectsCompat.equals(getName(), receipe.getName()) &&
              ObjectsCompat.equals(getIngredients(), receipe.getIngredients()) &&
              ObjectsCompat.equals(getDescription(), receipe.getDescription()) &&
              ObjectsCompat.equals(getUntitledfield(), receipe.getUntitledfield()) &&
              ObjectsCompat.equals(getCreatedAt(), receipe.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), receipe.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getIngredients())
      .append(getDescription())
      .append(getUntitledfield())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Receipe {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("ingredients=" + String.valueOf(getIngredients()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("untitledfield=" + String.valueOf(getUntitledfield()) + ", ")
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
  public static Receipe justId(String id) {
    return new Receipe(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      ingredients,
      description,
      untitledfield);
  }
  public interface BuildStep {
    Receipe build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep ingredients(String ingredients);
    BuildStep description(String description);
    BuildStep untitledfield(String untitledfield);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private String ingredients;
    private String description;
    private String untitledfield;
    @Override
     public Receipe build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Receipe(
          id,
          name,
          ingredients,
          description,
          untitledfield);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep ingredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep untitledfield(String untitledfield) {
        this.untitledfield = untitledfield;
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
    private CopyOfBuilder(String id, String name, String ingredients, String description, String untitledfield) {
      super.id(id);
      super.name(name)
        .ingredients(ingredients)
        .description(description)
        .untitledfield(untitledfield);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder ingredients(String ingredients) {
      return (CopyOfBuilder) super.ingredients(ingredients);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder untitledfield(String untitledfield) {
      return (CopyOfBuilder) super.untitledfield(untitledfield);
    }
  }
  
}
