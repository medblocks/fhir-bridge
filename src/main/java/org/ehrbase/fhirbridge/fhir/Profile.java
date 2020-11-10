package org.ehrbase.fhirbridge.fhir;

import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Profile {

    // Observation Profiles

    BODY_HEIGHT(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/body-height"),

    BLOOD_PRESSURE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/blood-pressure"),

    BODY_TEMP(Observation.class, "http://hl7.org/fhir/StructureDefinition/bodytemp"),

    CLINICAL_FRAILTY_SCALE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/frailty-score"),

    CORONARIRUS_NACHWEIS_TEST(Observation.class, "https://charite.infectioncontrol.de/fhir/core/StructureDefinition/CoronavirusNachweisTest"),

    FIO2(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/FiO2"),

    HEART_RATE(Observation.class, "http://hl7.org/fhir/StructureDefinition/heartrate"),

    PATIENT_IN_ICU(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/patient-in-icu"),

    PREGNANCY_STATUS(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pregnancy-status"),

    OBSERVATION_LAB(Observation.class, "https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/ObservationLab"),

    SOFA_SCORE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/sofa-score");

    private final Class<? extends Resource> resourceType;

    private final String uri;

    <T extends Resource> Profile(Class<T> resourceType, String uri) {
        this.resourceType = resourceType;
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public Class<? extends Resource> getResourceType() {
        return resourceType;
    }

    public static <T extends Resource> boolean isDefaultSupported(T resource) {
        return !(resource instanceof DiagnosticReport) && !(resource instanceof Observation);
    }

    public static <T extends Resource> List<Profile> resolveAll(T resource) {
        return resource.getMeta().getProfile().stream()
                .map(uri -> Profile.resolve(uri.getValue()))
                .filter(Objects::nonNull)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Profile resolve(String uri) {
        for (Profile profile : values()) {
            if (Objects.equals(profile.uri, uri)) {
                return profile;
            }
        }
        return null;
    }
}
