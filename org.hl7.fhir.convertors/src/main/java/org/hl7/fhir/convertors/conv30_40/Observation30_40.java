package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Observation30_40 {

    public static org.hl7.fhir.r4.model.Observation convertObservation(org.hl7.fhir.dstu3.model.Observation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation tgt = new org.hl7.fhir.r4.model.Observation();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertInstant(src.getIssuedElement()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.addInterpretation(VersionConvertor_30_40.convertCodeableConcept(src.getInterpretation()));
        if (src.hasComment())
            tgt.addNote().setText(src.getComment());
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent t : src.getRelated()) if (t.getType() == org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER)
            tgt.addHasMember(VersionConvertor_30_40.convertReference(t.getTarget()));
        else if (t.getType() == org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM)
            tgt.addDerivedFrom(VersionConvertor_30_40.convertReference(t.getTarget()));
        if (src.hasComponent()) {
            for (org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation convertObservation(org.hl7.fhir.r4.model.Observation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Observation tgt = new org.hl7.fhir.dstu3.model.Observation();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertInstant(src.getIssuedElement()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.setInterpretation(VersionConvertor_30_40.convertCodeableConcept(src.getInterpretationFirstRep()));
        if (src.hasNote())
            tgt.setComment(src.getNoteFirstRep().getText());
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        if (src.hasHasMember()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getHasMember()) tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER));
        }
        if (src.hasDerivedFrom()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM));
        }
        if (src.hasComponent()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.setInterpretation(VersionConvertor_30_40.convertCodeableConcept(src.getInterpretationFirstRep()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationComponentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_30_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.addInterpretation(VersionConvertor_30_40.convertCodeableConcept(src.getInterpretation()));
        if (src.hasReferenceRange()) {
            for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_30_40.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_30_40.convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasAppliesTo()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertRange(src.getAge()));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_30_40.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_30_40.convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasAppliesTo()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAppliesTo()) tgt.addAppliesTo(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAge())
            tgt.setAge(VersionConvertor_30_40.convertRange(src.getAge()));
        if (src.hasText())
            tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.r4.model.Reference src, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType type) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        tgt.setType(type);
        tgt.setTarget(VersionConvertor_30_40.convertReference(src));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.r4.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.dstu3.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.AMENDED;
            case CORRECTED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.CORRECTED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.NULL;
        }
    }
}
