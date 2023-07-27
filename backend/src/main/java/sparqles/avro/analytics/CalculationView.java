/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package sparqles.avro.analytics;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CalculationView extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CalculationView\",\"namespace\":\"sparqles.avro.analytics\",\"fields\":[{\"name\":\"endpoint\",\"type\":{\"type\":\"record\",\"name\":\"Endpoint\",\"namespace\":\"sparqles.avro\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"datasets\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Dataset\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"label\",\"type\":\"string\"}]}}}]}},{\"name\":\"VoID\",\"type\":\"boolean\"},{\"name\":\"SD\",\"type\":\"boolean\"},{\"name\":\"coherence\",\"type\":\"double\"},{\"name\":\"RS\",\"type\":\"double\"},{\"name\":\"lastUpdate\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public sparqles.avro.Endpoint endpoint;
  @Deprecated public boolean VoID;
  @Deprecated public boolean SD;
  @Deprecated public double coherence;
  @Deprecated public double RS;
  @Deprecated public long lastUpdate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public CalculationView() {}

  /**
   * All-args constructor.
   */
  public CalculationView(sparqles.avro.Endpoint endpoint, java.lang.Boolean VoID, java.lang.Boolean SD, java.lang.Double coherence, java.lang.Double RS, java.lang.Long lastUpdate) {
    this.endpoint = endpoint;
    this.VoID = VoID;
    this.SD = SD;
    this.coherence = coherence;
    this.RS = RS;
    this.lastUpdate = lastUpdate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return endpoint;
    case 1: return VoID;
    case 2: return SD;
    case 3: return coherence;
    case 4: return RS;
    case 5: return lastUpdate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: endpoint = (sparqles.avro.Endpoint)value$; break;
    case 1: VoID = (java.lang.Boolean)value$; break;
    case 2: SD = (java.lang.Boolean)value$; break;
    case 3: coherence = (java.lang.Double)value$; break;
    case 4: RS = (java.lang.Double)value$; break;
    case 5: lastUpdate = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'endpoint' field.
   */
  public sparqles.avro.Endpoint getEndpoint() {
    return endpoint;
  }

  /**
   * Sets the value of the 'endpoint' field.
   * @param value the value to set.
   */
  public void setEndpoint(sparqles.avro.Endpoint value) {
    this.endpoint = value;
  }

  /**
   * Gets the value of the 'VoID' field.
   */
  public java.lang.Boolean getVoID() {
    return VoID;
  }

  /**
   * Sets the value of the 'VoID' field.
   * @param value the value to set.
   */
  public void setVoID(java.lang.Boolean value) {
    this.VoID = value;
  }

  /**
   * Gets the value of the 'SD' field.
   */
  public java.lang.Boolean getSD() {
    return SD;
  }

  /**
   * Sets the value of the 'SD' field.
   * @param value the value to set.
   */
  public void setSD(java.lang.Boolean value) {
    this.SD = value;
  }

  /**
   * Gets the value of the 'coherence' field.
   */
  public java.lang.Double getCoherence() {
    return coherence;
  }

  /**
   * Sets the value of the 'coherence' field.
   * @param value the value to set.
   */
  public void setCoherence(java.lang.Double value) {
    this.coherence = value;
  }

  /**
   * Gets the value of the 'RS' field.
   */
  public java.lang.Double getRS() {
    return RS;
  }

  /**
   * Sets the value of the 'RS' field.
   * @param value the value to set.
   */
  public void setRS(java.lang.Double value) {
    this.RS = value;
  }

  /**
   * Gets the value of the 'lastUpdate' field.
   */
  public java.lang.Long getLastUpdate() {
    return lastUpdate;
  }

  /**
   * Sets the value of the 'lastUpdate' field.
   * @param value the value to set.
   */
  public void setLastUpdate(java.lang.Long value) {
    this.lastUpdate = value;
  }

  /** Creates a new CalculationView RecordBuilder */
  public static sparqles.avro.analytics.CalculationView.Builder newBuilder() {
    return new sparqles.avro.analytics.CalculationView.Builder();
  }
  
  /** Creates a new CalculationView RecordBuilder by copying an existing Builder */
  public static sparqles.avro.analytics.CalculationView.Builder newBuilder(sparqles.avro.analytics.CalculationView.Builder other) {
    return new sparqles.avro.analytics.CalculationView.Builder(other);
  }
  
  /** Creates a new CalculationView RecordBuilder by copying an existing CalculationView instance */
  public static sparqles.avro.analytics.CalculationView.Builder newBuilder(sparqles.avro.analytics.CalculationView other) {
    return new sparqles.avro.analytics.CalculationView.Builder(other);
  }
  
  /**
   * RecordBuilder for CalculationView instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CalculationView>
    implements org.apache.avro.data.RecordBuilder<CalculationView> {

    private sparqles.avro.Endpoint endpoint;
    private boolean VoID;
    private boolean SD;
    private double coherence;
    private double RS;
    private long lastUpdate;

    /** Creates a new Builder */
    private Builder() {
      super(sparqles.avro.analytics.CalculationView.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(sparqles.avro.analytics.CalculationView.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.endpoint)) {
        this.endpoint = data().deepCopy(fields()[0].schema(), other.endpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VoID)) {
        this.VoID = data().deepCopy(fields()[1].schema(), other.VoID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.SD)) {
        this.SD = data().deepCopy(fields()[2].schema(), other.SD);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.coherence)) {
        this.coherence = data().deepCopy(fields()[3].schema(), other.coherence);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.RS)) {
        this.RS = data().deepCopy(fields()[4].schema(), other.RS);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[5].schema(), other.lastUpdate);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing CalculationView instance */
    private Builder(sparqles.avro.analytics.CalculationView other) {
            super(sparqles.avro.analytics.CalculationView.SCHEMA$);
      if (isValidValue(fields()[0], other.endpoint)) {
        this.endpoint = data().deepCopy(fields()[0].schema(), other.endpoint);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.VoID)) {
        this.VoID = data().deepCopy(fields()[1].schema(), other.VoID);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.SD)) {
        this.SD = data().deepCopy(fields()[2].schema(), other.SD);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.coherence)) {
        this.coherence = data().deepCopy(fields()[3].schema(), other.coherence);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.RS)) {
        this.RS = data().deepCopy(fields()[4].schema(), other.RS);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.lastUpdate)) {
        this.lastUpdate = data().deepCopy(fields()[5].schema(), other.lastUpdate);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'endpoint' field */
    public sparqles.avro.Endpoint getEndpoint() {
      return endpoint;
    }
    
    /** Sets the value of the 'endpoint' field */
    public sparqles.avro.analytics.CalculationView.Builder setEndpoint(sparqles.avro.Endpoint value) {
      validate(fields()[0], value);
      this.endpoint = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'endpoint' field has been set */
    public boolean hasEndpoint() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'endpoint' field */
    public sparqles.avro.analytics.CalculationView.Builder clearEndpoint() {
      endpoint = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'VoID' field */
    public java.lang.Boolean getVoID() {
      return VoID;
    }
    
    /** Sets the value of the 'VoID' field */
    public sparqles.avro.analytics.CalculationView.Builder setVoID(boolean value) {
      validate(fields()[1], value);
      this.VoID = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'VoID' field has been set */
    public boolean hasVoID() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'VoID' field */
    public sparqles.avro.analytics.CalculationView.Builder clearVoID() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'SD' field */
    public java.lang.Boolean getSD() {
      return SD;
    }
    
    /** Sets the value of the 'SD' field */
    public sparqles.avro.analytics.CalculationView.Builder setSD(boolean value) {
      validate(fields()[2], value);
      this.SD = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'SD' field has been set */
    public boolean hasSD() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'SD' field */
    public sparqles.avro.analytics.CalculationView.Builder clearSD() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'coherence' field */
    public java.lang.Double getCoherence() {
      return coherence;
    }
    
    /** Sets the value of the 'coherence' field */
    public sparqles.avro.analytics.CalculationView.Builder setCoherence(double value) {
      validate(fields()[3], value);
      this.coherence = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'coherence' field has been set */
    public boolean hasCoherence() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'coherence' field */
    public sparqles.avro.analytics.CalculationView.Builder clearCoherence() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'RS' field */
    public java.lang.Double getRS() {
      return RS;
    }
    
    /** Sets the value of the 'RS' field */
    public sparqles.avro.analytics.CalculationView.Builder setRS(double value) {
      validate(fields()[4], value);
      this.RS = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'RS' field has been set */
    public boolean hasRS() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'RS' field */
    public sparqles.avro.analytics.CalculationView.Builder clearRS() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'lastUpdate' field */
    public java.lang.Long getLastUpdate() {
      return lastUpdate;
    }
    
    /** Sets the value of the 'lastUpdate' field */
    public sparqles.avro.analytics.CalculationView.Builder setLastUpdate(long value) {
      validate(fields()[5], value);
      this.lastUpdate = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'lastUpdate' field has been set */
    public boolean hasLastUpdate() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'lastUpdate' field */
    public sparqles.avro.analytics.CalculationView.Builder clearLastUpdate() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public CalculationView build() {
      try {
        CalculationView record = new CalculationView();
        record.endpoint = fieldSetFlags()[0] ? this.endpoint : (sparqles.avro.Endpoint) defaultValue(fields()[0]);
        record.VoID = fieldSetFlags()[1] ? this.VoID : (java.lang.Boolean) defaultValue(fields()[1]);
        record.SD = fieldSetFlags()[2] ? this.SD : (java.lang.Boolean) defaultValue(fields()[2]);
        record.coherence = fieldSetFlags()[3] ? this.coherence : (java.lang.Double) defaultValue(fields()[3]);
        record.RS = fieldSetFlags()[4] ? this.RS : (java.lang.Double) defaultValue(fields()[4]);
        record.lastUpdate = fieldSetFlags()[5] ? this.lastUpdate : (java.lang.Long) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
