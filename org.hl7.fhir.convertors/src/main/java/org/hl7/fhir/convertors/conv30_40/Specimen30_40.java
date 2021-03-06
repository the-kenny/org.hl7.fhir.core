package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Specimen30_40 {

    public static org.hl7.fhir.r4.model.Specimen convertSpecimen(org.hl7.fhir.dstu3.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen tgt = new org.hl7.fhir.r4.model.Specimen();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(VersionConvertor_30_40.convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertSpecimenStatus(src.getStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(VersionConvertor_30_40.convertDateTime(src.getReceivedTimeElement()));
        if (src.hasParent()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.addParent(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasRequest()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getRequest()) tgt.addRequest(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        if (src.hasProcessing()) {
            for (org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        }
        if (src.hasContainer()) {
            for (org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen convertSpecimen(org.hl7.fhir.r4.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen tgt = new org.hl7.fhir.dstu3.model.Specimen();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(VersionConvertor_30_40.convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertSpecimenStatus(src.getStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(VersionConvertor_30_40.convertDateTime(src.getReceivedTimeElement()));
        if (src.hasParent()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasRequest()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        if (src.hasProcessing()) {
            for (org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        }
        if (src.hasContainer()) {
            for (org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(VersionConvertor_30_40.convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(VersionConvertor_30_40.convertType(src.getCollected()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(VersionConvertor_30_40.convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(VersionConvertor_30_40.convertType(src.getCollected()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_30_40.convertCodeableConcept(src.getBodySite()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(VersionConvertor_30_40.convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(VersionConvertor_30_40.convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(VersionConvertor_30_40.convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(VersionConvertor_30_40.convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasProcedure())
            tgt.setProcedure(VersionConvertor_30_40.convertCodeableConcept(src.getProcedure()));
        if (src.hasAdditive()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAdditive()) tgt.addAdditive(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasTime())
            tgt.setTime(VersionConvertor_30_40.convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasProcedure())
            tgt.setProcedure(VersionConvertor_30_40.convertCodeableConcept(src.getProcedure()));
        if (src.hasAdditive()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getAdditive()) tgt.addAdditive(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasTime())
            tgt.setTime(VersionConvertor_30_40.convertType(src.getTime()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus convertSpecimenStatus(org.hl7.fhir.r4.model.Specimen.SpecimenStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AVAILABLE:
                return org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.AVAILABLE;
            case UNAVAILABLE:
                return org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNAVAILABLE;
            case UNSATISFACTORY:
                return org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNSATISFACTORY;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Specimen.SpecimenStatus convertSpecimenStatus(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AVAILABLE:
                return org.hl7.fhir.r4.model.Specimen.SpecimenStatus.AVAILABLE;
            case UNAVAILABLE:
                return org.hl7.fhir.r4.model.Specimen.SpecimenStatus.UNAVAILABLE;
            case UNSATISFACTORY:
                return org.hl7.fhir.r4.model.Specimen.SpecimenStatus.UNSATISFACTORY;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Specimen.SpecimenStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Specimen.SpecimenStatus.NULL;
        }
    }
}
