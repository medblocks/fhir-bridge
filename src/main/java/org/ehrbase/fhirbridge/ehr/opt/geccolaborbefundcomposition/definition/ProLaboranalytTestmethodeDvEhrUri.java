package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.DvEHRURI;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-09-08T14:37:11.021452+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.5.0"
)
@OptionFor("DV_EHR_URI")
public class ProLaboranalytTestmethodeDvEhrUri implements RMEntity, ProLaboranalytTestmethodeChoice {
  /**
   * Path: Laborbefund/Laborergebnis/Jedes Ereignis/Pro Laboranalyt/Testmethode/Testmethode
   * Description: Die Beschreibung der Methode, mit der der Test nur für diesen Analyten durchgeführt wurde.
   */
  @Path("")
  private DvEHRURI testmethode;

  public void setTestmethode(DvEHRURI testmethode) {
     this.testmethode = testmethode;
  }

  public DvEHRURI getTestmethode() {
     return this.testmethode ;
  }
}
