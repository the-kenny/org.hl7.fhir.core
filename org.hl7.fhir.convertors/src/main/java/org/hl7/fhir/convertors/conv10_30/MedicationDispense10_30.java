package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.Dosage;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationDispense10_30 {

    public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_30.convertReference(t));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        tgt.setDaysSupply(VersionConvertor_10_30.convertSimpleQuantity(src.getDaysSupply()));
        tgt.setWhenPrepared(src.getWhenPrepared());
        tgt.setWhenHandedOver(src.getWhenHandedOver());
        tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifierFirstRep()));
        tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_30.convertReference(t));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        tgt.setDaysSupply(VersionConvertor_10_30.convertSimpleQuantity(src.getDaysSupply()));
        tgt.setWhenPrepared(src.getWhenPrepared());
        tgt.setWhenHandedOver(src.getWhenHandedOver());
        tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(VersionConvertor_10_30.convertTiming(src.getTiming()));
        tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
        tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        tgt.setDose(VersionConvertor_10_30.convertType(src.getDose()));
        tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(VersionConvertor_10_30.convertTiming(src.getTiming()));
        tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        tgt.setSite(VersionConvertor_10_30.convertType(src.getSite()));
        tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        tgt.setDose(VersionConvertor_10_30.convertType(src.getDose()));
        tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED;
            default:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED;
            default:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }
}