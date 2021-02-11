package org.ehrbase.fhirbridge.ehr.opt.geccoprozedurcomposition.definition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum NameDerProzedurDefiningCode implements EnumValueSet {
  COMPUTERIZED_AXIAL_TOMOGRAPHY_PROCEDURE("Computerized axial tomography (procedure)", "Computerized axial tomography (procedure)", "SNOMED Clinical Terms", "77477000"),

  DIAGNOSTIC_ULTRASONOGRAPHY_PROCEDURE("Diagnostic ultrasonography (procedure)", "Diagnostic ultrasonography (procedure)", "SNOMED Clinical Terms", "16310003"),

  DIALYSIS_PROCEDURE_PROCEDURE("Dialysis procedure (procedure)", "Dialysis procedure (procedure)", "SNOMED Clinical Terms", "108241001"),

  EXTRACORPOREAL_MEMBRANE_OXYGENATION_PROCEDURE("Extracorporeal membrane oxygenation (procedure)", "Extracorporeal membrane oxygenation (procedure)", "SNOMED Clinical Terms", "233573008"),

  APHERESIS_PROCEDURE("Apheresis (procedure)", "Apheresis (procedure)", "SNOMED Clinical Terms", "127788007"),

  OXYGEN_ADMINISTRATION_BY_NASAL_CANNULA_PROCEDURE("Oxygen administration by nasal cannula (procedure)", "Oxygen administration by nasal cannula (procedure)", "SNOMED Clinical Terms", "371907003"),

  PLAIN_RADIOGRAPHY("Plain radiography", "Plain radiography", "SNOMED Clinical Terms", "168537006"),

  ARTIFICIAL_RESPIRATION_PROCEDURE("Artificial respiration (procedure)", "Artificial respiration (procedure)", "SNOMED Clinical Terms", "40617009"),

  PLACING_SUBJECT_IN_PRONE_POSITION_PROCEDURE("Placing subject in prone position (procedure)", "Placing subject in prone position (procedure)", "SNOMED Clinical Terms", "431182000"),

  NONINVASIVE_VENTILATION_PROCEDURE("Noninvasive ventilation (procedure)", "Noninvasive ventilation (procedure)", "SNOMED Clinical Terms", "428311008");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  NameDerProzedurDefiningCode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
     return this.value ;
  }

  public String getDescription() {
     return this.description ;
  }

  public String getTerminologyId() {
     return this.terminologyId ;
  }

  public String getCode() {
     return this.code ;
  }
}
