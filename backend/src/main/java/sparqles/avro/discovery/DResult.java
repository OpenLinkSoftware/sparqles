/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package sparqles.avro.discovery;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class DResult extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"DResult\",\"namespace\":\"sparqles.avro.discovery\",\"fields\":[{\"name\":\"endpointResult\",\"type\":{\"type\":\"record\",\"name\":\"EndpointResult\",\"namespace\":\"sparqles.avro\",\"fields\":[{\"name\":\"endpoint\",\"type\":{\"type\":\"record\",\"name\":\"Endpoint\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"datasets\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Dataset\",\"fields\":[{\"name\":\"uri\",\"type\":\"string\"},{\"name\":\"label\",\"type\":\"string\"}]}}}]}},{\"name\":\"start\",\"type\":\"long\"},{\"name\":\"end\",\"type\":\"long\"}],\"import\":\"Endpoint.avsc\"}},{\"name\":\"RobotsTXT\",\"type\":{\"type\":\"record\",\"name\":\"RobotsTXT\",\"fields\":[{\"name\":\"hasRobotsTXT\",\"type\":\"boolean\",\"default\":false},{\"name\":\"allowedByRobotsTXT\",\"type\":\"boolean\",\"default\":true},{\"name\":\"sitemapXML\",\"type\":\"boolean\",\"default\":false},{\"name\":\"sitemapXMLSPARQL\",\"type\":\"boolean\",\"default\":false},{\"name\":\"sitemapXMLSPARQLMatch\",\"type\":\"boolean\",\"default\":false},{\"name\":\"sitemapXMLVoiD\",\"type\":\"boolean\",\"default\":false},{\"name\":\"Exception\",\"type\":[\"string\",\"null\"]}]}},{\"name\":\"descriptionFiles\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"DGETInfo\",\"fields\":[{\"name\":\"allowedByRobotsTXT\",\"type\":\"boolean\",\"default\":true},{\"name\":\"Operation\",\"type\":\"string\"},{\"name\":\"URL\",\"type\":\"string\"},{\"name\":\"Exception\",\"type\":[\"string\",\"null\"]},{\"name\":\"ResponseType\",\"type\":[\"string\",\"null\"]},{\"name\":\"ResponseCode\",\"type\":[\"string\",\"null\"]},{\"name\":\"ResponseServer\",\"type\":[\"string\",\"null\"]},{\"name\":\"ResponseLink\",\"type\":[\"string\",\"null\"]},{\"name\":\"Content\",\"type\":[\"string\",\"null\"]},{\"name\":\"SPARQLDESCpreds\",\"type\":{\"type\":\"map\",\"values\":[\"int\"]}},{\"name\":\"voiDpreds\",\"type\":{\"type\":\"map\",\"values\":[\"int\"]}}]}}},{\"name\":\"queryInfo\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"QueryInfo\",\"fields\":[{\"name\":\"URL\",\"type\":\"string\"},{\"name\":\"Operation\",\"type\":\"string\"},{\"name\":\"Exception\",\"type\":[\"string\",\"null\"]},{\"name\":\"allowedByRobotsTXT\",\"type\":\"boolean\",\"default\":true},{\"name\":\"Results\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}}],\"import\":\"EndpointResult.avsc\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public sparqles.avro.EndpointResult endpointResult;
  @Deprecated public sparqles.avro.discovery.RobotsTXT RobotsTXT;
  @Deprecated public java.util.List<sparqles.avro.discovery.DGETInfo> descriptionFiles;
  @Deprecated public java.util.List<sparqles.avro.discovery.QueryInfo> queryInfo;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public DResult() {}

  /**
   * All-args constructor.
   */
  public DResult(sparqles.avro.EndpointResult endpointResult, sparqles.avro.discovery.RobotsTXT RobotsTXT, java.util.List<sparqles.avro.discovery.DGETInfo> descriptionFiles, java.util.List<sparqles.avro.discovery.QueryInfo> queryInfo) {
    this.endpointResult = endpointResult;
    this.RobotsTXT = RobotsTXT;
    this.descriptionFiles = descriptionFiles;
    this.queryInfo = queryInfo;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return endpointResult;
    case 1: return RobotsTXT;
    case 2: return descriptionFiles;
    case 3: return queryInfo;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: endpointResult = (sparqles.avro.EndpointResult)value$; break;
    case 1: RobotsTXT = (sparqles.avro.discovery.RobotsTXT)value$; break;
    case 2: descriptionFiles = (java.util.List<sparqles.avro.discovery.DGETInfo>)value$; break;
    case 3: queryInfo = (java.util.List<sparqles.avro.discovery.QueryInfo>)value$; break;
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
   * Gets the value of the 'RobotsTXT' field.
   */
  public sparqles.avro.discovery.RobotsTXT getRobotsTXT() {
    return RobotsTXT;
  }

  /**
   * Sets the value of the 'RobotsTXT' field.
   * @param value the value to set.
   */
  public void setRobotsTXT(sparqles.avro.discovery.RobotsTXT value) {
    this.RobotsTXT = value;
  }

  /**
   * Gets the value of the 'descriptionFiles' field.
   */
  public java.util.List<sparqles.avro.discovery.DGETInfo> getDescriptionFiles() {
    return descriptionFiles;
  }

  /**
   * Sets the value of the 'descriptionFiles' field.
   * @param value the value to set.
   */
  public void setDescriptionFiles(java.util.List<sparqles.avro.discovery.DGETInfo> value) {
    this.descriptionFiles = value;
  }

  /**
   * Gets the value of the 'queryInfo' field.
   */
  public java.util.List<sparqles.avro.discovery.QueryInfo> getQueryInfo() {
    return queryInfo;
  }

  /**
   * Sets the value of the 'queryInfo' field.
   * @param value the value to set.
   */
  public void setQueryInfo(java.util.List<sparqles.avro.discovery.QueryInfo> value) {
    this.queryInfo = value;
  }

  /** Creates a new DResult RecordBuilder */
  public static sparqles.avro.discovery.DResult.Builder newBuilder() {
    return new sparqles.avro.discovery.DResult.Builder();
  }
  
  /** Creates a new DResult RecordBuilder by copying an existing Builder */
  public static sparqles.avro.discovery.DResult.Builder newBuilder(sparqles.avro.discovery.DResult.Builder other) {
    return new sparqles.avro.discovery.DResult.Builder(other);
  }
  
  /** Creates a new DResult RecordBuilder by copying an existing DResult instance */
  public static sparqles.avro.discovery.DResult.Builder newBuilder(sparqles.avro.discovery.DResult other) {
    return new sparqles.avro.discovery.DResult.Builder(other);
  }
  
  /**
   * RecordBuilder for DResult instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<DResult>
    implements org.apache.avro.data.RecordBuilder<DResult> {

    private sparqles.avro.EndpointResult endpointResult;
    private sparqles.avro.discovery.RobotsTXT RobotsTXT;
    private java.util.List<sparqles.avro.discovery.DGETInfo> descriptionFiles;
    private java.util.List<sparqles.avro.discovery.QueryInfo> queryInfo;

    /** Creates a new Builder */
    private Builder() {
      super(sparqles.avro.discovery.DResult.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(sparqles.avro.discovery.DResult.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.endpointResult)) {
        this.endpointResult = data().deepCopy(fields()[0].schema(), other.endpointResult);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.RobotsTXT)) {
        this.RobotsTXT = data().deepCopy(fields()[1].schema(), other.RobotsTXT);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.descriptionFiles)) {
        this.descriptionFiles = data().deepCopy(fields()[2].schema(), other.descriptionFiles);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.queryInfo)) {
        this.queryInfo = data().deepCopy(fields()[3].schema(), other.queryInfo);
        fieldSetFlags()[3] = true;
      }
    }
    
    /** Creates a Builder by copying an existing DResult instance */
    private Builder(sparqles.avro.discovery.DResult other) {
            super(sparqles.avro.discovery.DResult.SCHEMA$);
      if (isValidValue(fields()[0], other.endpointResult)) {
        this.endpointResult = data().deepCopy(fields()[0].schema(), other.endpointResult);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.RobotsTXT)) {
        this.RobotsTXT = data().deepCopy(fields()[1].schema(), other.RobotsTXT);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.descriptionFiles)) {
        this.descriptionFiles = data().deepCopy(fields()[2].schema(), other.descriptionFiles);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.queryInfo)) {
        this.queryInfo = data().deepCopy(fields()[3].schema(), other.queryInfo);
        fieldSetFlags()[3] = true;
      }
    }

    /** Gets the value of the 'endpointResult' field */
    public sparqles.avro.EndpointResult getEndpointResult() {
      return endpointResult;
    }
    
    /** Sets the value of the 'endpointResult' field */
    public sparqles.avro.discovery.DResult.Builder setEndpointResult(sparqles.avro.EndpointResult value) {
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
    public sparqles.avro.discovery.DResult.Builder clearEndpointResult() {
      endpointResult = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'RobotsTXT' field */
    public sparqles.avro.discovery.RobotsTXT getRobotsTXT() {
      return RobotsTXT;
    }
    
    /** Sets the value of the 'RobotsTXT' field */
    public sparqles.avro.discovery.DResult.Builder setRobotsTXT(sparqles.avro.discovery.RobotsTXT value) {
      validate(fields()[1], value);
      this.RobotsTXT = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'RobotsTXT' field has been set */
    public boolean hasRobotsTXT() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'RobotsTXT' field */
    public sparqles.avro.discovery.DResult.Builder clearRobotsTXT() {
      RobotsTXT = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'descriptionFiles' field */
    public java.util.List<sparqles.avro.discovery.DGETInfo> getDescriptionFiles() {
      return descriptionFiles;
    }
    
    /** Sets the value of the 'descriptionFiles' field */
    public sparqles.avro.discovery.DResult.Builder setDescriptionFiles(java.util.List<sparqles.avro.discovery.DGETInfo> value) {
      validate(fields()[2], value);
      this.descriptionFiles = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'descriptionFiles' field has been set */
    public boolean hasDescriptionFiles() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'descriptionFiles' field */
    public sparqles.avro.discovery.DResult.Builder clearDescriptionFiles() {
      descriptionFiles = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'queryInfo' field */
    public java.util.List<sparqles.avro.discovery.QueryInfo> getQueryInfo() {
      return queryInfo;
    }
    
    /** Sets the value of the 'queryInfo' field */
    public sparqles.avro.discovery.DResult.Builder setQueryInfo(java.util.List<sparqles.avro.discovery.QueryInfo> value) {
      validate(fields()[3], value);
      this.queryInfo = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'queryInfo' field has been set */
    public boolean hasQueryInfo() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'queryInfo' field */
    public sparqles.avro.discovery.DResult.Builder clearQueryInfo() {
      queryInfo = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    public DResult build() {
      try {
        DResult record = new DResult();
        record.endpointResult = fieldSetFlags()[0] ? this.endpointResult : (sparqles.avro.EndpointResult) defaultValue(fields()[0]);
        record.RobotsTXT = fieldSetFlags()[1] ? this.RobotsTXT : (sparqles.avro.discovery.RobotsTXT) defaultValue(fields()[1]);
        record.descriptionFiles = fieldSetFlags()[2] ? this.descriptionFiles : (java.util.List<sparqles.avro.discovery.DGETInfo>) defaultValue(fields()[2]);
        record.queryInfo = fieldSetFlags()[3] ? this.queryInfo : (java.util.List<sparqles.avro.discovery.QueryInfo>) defaultValue(fields()[3]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
