/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package sparqles.avro.calculation;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class CResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CResult\",\"namespace\":\"sparqles.avro.calculation\",\"fields\":[{\"name\":\"endpointResult\",\"type\":{\"type\":\"record\",\"name\":\"EndpointResult\",\"namespace\":\"sparqles.avro\",\"fields\":[{\"name\":\"endpoint\",\"type\":{\"type\":\"record\",\"name\":\"Endpoint\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"datasets\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Dataset\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"label\",\"type\":\"string\"}]}}}]}},{\"name\":\"start\",\"type\":\"long\"},{\"name\":\"end\",\"type\":\"long\"}],\"import\":\"Endpoint.avsc\"}},{\"name\":\"VoID\",\"type\":\"string\"},{\"name\":\"SD\",\"type\":\"string\"},{\"name\":\"coherence\",\"type\":\"double\"},{\"name\":\"RS\",\"type\":\"double\"}],\"import\":\"EndpointResult.avsc\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public sparqles.avro.EndpointResult endpointResult;
  @Deprecated public java.lang.CharSequence VoID;
  @Deprecated public java.lang.CharSequence SD;
  @Deprecated public double coherence;
  @Deprecated public double RS;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public CResult() {}

  /**
   * All-args constructor.
   */
  public CResult(sparqles.avro.EndpointResult endpointResult, java.lang.CharSequence VoID, java.lang.CharSequence SD, java.lang.Double coherence, java.lang.Double RS) {
    this.endpointResult = endpointResult;
    this.VoID = VoID;
    this.SD = SD;
    this.coherence = coherence;
    this.RS = RS;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return endpointResult;
    case 1: return VoID;
    case 2: return SD;
    case 3: return coherence;
    case 4: return RS;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: endpointResult = (sparqles.avro.EndpointResult)value$; break;
    case 1: VoID = (java.lang.CharSequence)value$; break;
    case 2: SD = (java.lang.CharSequence)value$; break;
    case 3: coherence = (java.lang.Double)value$; break;
    case 4: RS = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'endpointResult' field.
   */
  public sparqles.avro.EndpointResult getEndpointResult() {
    return endpointResult;
  }

  /**
   * Sets the value of the 'endpointResult' field.
   * @param value the value to set.
   */
  public void setEndpointResult(sparqles.avro.EndpointResult value) {
    this.endpointResult = value;
  }

  /**
   * Gets the value of the 'VoID' field.
   */
  public java.lang.CharSequence getVoID() {
    return VoID;
  }

  /**
   * Sets the value of the 'VoID' field.
   * @param value the value to set.
   */
  public void setVoID(java.lang.CharSequence value) {
    this.VoID = value;
  }

  /**
   * Gets the value of the 'SD' field.
   */
  public java.lang.CharSequence getSD() {
    return SD;
  }

  /**
   * Sets the value of the 'SD' field.
   * @param value the value to set.
   */
  public void setSD(java.lang.CharSequence value) {
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

  /** Creates a new CResult RecordBuilder */
  public static sparqles.avro.calculation.CResult.Builder newBuilder() {
    return new sparqles.avro.calculation.CResult.Builder();
  }
  
  /** Creates a new CResult RecordBuilder by copying an existing Builder */
  public static sparqles.avro.calculation.CResult.Builder newBuilder(sparqles.avro.calculation.CResult.Builder other) {
    return new sparqles.avro.calculation.CResult.Builder(other);
  }
  
  /** Creates a new CResult RecordBuilder by copying an existing CResult instance */
  public static sparqles.avro.calculation.CResult.Builder newBuilder(sparqles.avro.calculation.CResult other) {
    return new sparqles.avro.calculation.CResult.Builder(other);
  }
  
  /**
   * RecordBuilder for CResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CResult>
    implements org.apache.avro.data.RecordBuilder<CResult> {

    private sparqles.avro.EndpointResult endpointResult;
    private java.lang.CharSequence VoID;
    private java.lang.CharSequence SD;
    private double coherence;
    private double RS;

    /** Creates a new Builder */
    private Builder() {
      super(sparqles.avro.calculation.CResult.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(sparqles.avro.calculation.CResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.endpointResult)) {
        this.endpointResult = data().deepCopy(fields()[0].schema(), other.endpointResult);
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
    }
    
    /** Creates a Builder by copying an existing CResult instance */
    private Builder(sparqles.avro.calculation.CResult other) {
            super(sparqles.avro.calculation.CResult.SCHEMA$);
      if (isValidValue(fields()[0], other.endpointResult)) {
        this.endpointResult = data().deepCopy(fields()[0].schema(), other.endpointResult);
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
    }

    /** Gets the value of the 'endpointResult' field */
    public sparqles.avro.EndpointResult getEndpointResult() {
      return endpointResult;
    }
    
    /** Sets the value of the 'endpointResult' field */
    public sparqles.avro.calculation.CResult.Builder setEndpointResult(sparqles.avro.EndpointResult value) {
      validate(fields()[0], value);
      this.endpointResult = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'endpointResult' field has been set */
    public boolean hasEndpointResult() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'endpointResult' field */
    public sparqles.avro.calculation.CResult.Builder clearEndpointResult() {
      endpointResult = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'VoID' field */
    public java.lang.CharSequence getVoID() {
      return VoID;
    }
    
    /** Sets the value of the 'VoID' field */
    public sparqles.avro.calculation.CResult.Builder setVoID(java.lang.CharSequence value) {
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
    public sparqles.avro.calculation.CResult.Builder clearVoID() {
      VoID = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'SD' field */
    public java.lang.CharSequence getSD() {
      return SD;
    }
    
    /** Sets the value of the 'SD' field */
    public sparqles.avro.calculation.CResult.Builder setSD(java.lang.CharSequence value) {
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
    public sparqles.avro.calculation.CResult.Builder clearSD() {
      SD = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'coherence' field */
    public java.lang.Double getCoherence() {
      return coherence;
    }
    
    /** Sets the value of the 'coherence' field */
    public sparqles.avro.calculation.CResult.Builder setCoherence(double value) {
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
    public sparqles.avro.calculation.CResult.Builder clearCoherence() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'RS' field */
    public java.lang.Double getRS() {
      return RS;
    }
    
    /** Sets the value of the 'RS' field */
    public sparqles.avro.calculation.CResult.Builder setRS(double value) {
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
    public sparqles.avro.calculation.CResult.Builder clearRS() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    public CResult build() {
      try {
        CResult record = new CResult();
        record.endpointResult = fieldSetFlags()[0] ? this.endpointResult : (sparqles.avro.EndpointResult) defaultValue(fields()[0]);
        record.VoID = fieldSetFlags()[1] ? this.VoID : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.SD = fieldSetFlags()[2] ? this.SD : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.coherence = fieldSetFlags()[3] ? this.coherence : (java.lang.Double) defaultValue(fields()[3]);
        record.RS = fieldSetFlags()[4] ? this.RS : (java.lang.Double) defaultValue(fields()[4]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
