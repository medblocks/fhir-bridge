package org.ehrbase.fhirbridge.ehr.converter.oxygensaturation;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.datavalues.quantity.DvProportion;
import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.client.classgenerator.shareddefinition.Category;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.Setting;
import org.ehrbase.client.classgenerator.shareddefinition.Territory;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConversionException;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.ContextConverter;
import org.ehrbase.fhirbridge.ehr.opt.pulsoxymetriecomposition.PulsoxymetrieComposition;
import org.ehrbase.fhirbridge.ehr.opt.pulsoxymetriecomposition.definition.PulsoxymetrieObservation;
import org.hl7.fhir.r4.model.Observation;

public class OxygenSaturationConverter implements CompositionConverter<PulsoxymetrieComposition, Observation> {

    @Override
    public Observation fromComposition(PulsoxymetrieComposition composition) throws CompositionConversionException {
        return null;
    }

    @Override
    public PulsoxymetrieComposition toComposition(Observation observation) throws CompositionConversionException {
        PulsoxymetrieComposition composition = new PulsoxymetrieComposition();
        new ContextConverter().mapStatus(composition, observation);
        mapKategorie(composition, observation);
        mapPulsoxymetrieObservation(composition, observation);
        setMandatoryFields(composition, observation);
        return composition;
    }

    private void setMandatoryFields(PulsoxymetrieComposition composition, Observation observation) {
        composition.setLanguage(Language.DE);
        composition.setCategoryDefiningCode(Category.EVENT);
        composition.setComposer(new PartySelf());
        composition.setStartTimeValue(observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());
        composition.setEndTimeValue(observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());
        composition.setLocation("test");
        composition.setTerritory(Territory.DE);
        composition.setSettingDefiningCode(Setting.SECONDARY_MEDICAL_CARE);
    }

    private void mapKategorie(PulsoxymetrieComposition composition, Observation observation) {
        if (observation.getCategory().size() > 1) {
            throw new UnprocessableEntityException("Fhir-Bridge does not support more then one Category Code value");
        }//TODO
        composition.setKategorieValue(observation.getCategory().get(0).getCoding()
                .get(0).getCode());
    }

    private void mapPulsoxymetrieObservation(PulsoxymetrieComposition composition, Observation observation) {
        PulsoxymetrieObservation pulsoxymetrieObservation = new PulsoxymetrieObservation();

        pulsoxymetrieObservation.setLanguage(Language.DE);
        pulsoxymetrieObservation.setTimeValue(observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());
        pulsoxymetrieObservation.setOriginValue(observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());
        pulsoxymetrieObservation.setSubject(new PartySelf());

        DvProportion dvProportion = new DvProportion();
        dvProportion.setNumerator(observation.getValueQuantity().getValue().doubleValue());
        dvProportion.setDenominator(100.0);
        dvProportion.setType(2L);

        pulsoxymetrieObservation.setSpo(dvProportion);
        composition.setPulsoxymetrie(pulsoxymetrieObservation);
    }
}
