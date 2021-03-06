package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;

public class MedicationDispense10_40 {

    public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_40.convertType(src.getMedication()));
        }
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getPatient()));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasQuantity()) {
            tgt.setQuantity(VersionConvertor_10_40.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDaysSupply()) {
            tgt.setDaysSupply(VersionConvertor_10_40.convertSimpleQuantity(src.getDaysSupply()));
        }
        if (src.hasWhenPrepared()) {
            tgt.setWhenPrepared(src.getWhenPrepared());
        }
        if (src.hasWhenHandedOver()) {
            tgt.setWhenHandedOver(src.getWhenHandedOver());
        }
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_40.convertReference(src.getDestination()));
        }
        if (src.hasReceiver()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        }
        if (src.hasSubstitution()) {
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifierFirstRep()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_40.convertType(src.getMedication()));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_40.convertReference(src.getSubject()));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasQuantity()) {
            tgt.setQuantity(VersionConvertor_10_40.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDaysSupply()) {
            tgt.setDaysSupply(VersionConvertor_10_40.convertSimpleQuantity(src.getDaysSupply()));
        }
        if (src.hasWhenPrepared()) {
            tgt.setWhenPrepared(src.getWhenPrepared());
        }
        if (src.hasWhenHandedOver()) {
            tgt.setWhenHandedOver(src.getWhenHandedOver());
        }
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_40.convertReference(src.getDestination()));
        }
        if (src.hasReceiver()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        }
        if (src.hasSubstitution()) {
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_40.convertTiming(src.getTiming()));
        }
        if (src.hasAsNeeded()) {
            tgt.setAsNeeded(VersionConvertor_10_40.convertType(src.getAsNeeded()));
        }
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasMethod()) {
            tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        }
        if (src.hasDose() || src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasDose())
                dr.setDose(VersionConvertor_10_40.convertType(src.getDose()));
            if (src.hasRate())
                dr.setRate(VersionConvertor_10_40.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_40.convertRatio(src.getMaxDosePerPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_40.convertTiming(src.getTiming()));
        }
        if (src.hasAsNeeded()) {
            tgt.setAsNeeded(VersionConvertor_10_40.convertType(src.getAsNeeded()));
        }
        if (src.hasSite()) {
            tgt.setSite(VersionConvertor_10_40.convertType(src.getSite()));
        }
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasMethod()) {
            tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        }
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
            tgt.setDose(VersionConvertor_10_40.convertType(src.getDoseAndRate().get(0).getDose()));
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_40.convertRatio(src.getMaxDosePerPeriod()));
        }
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(VersionConvertor_10_40.convertType(src.getDoseAndRate().get(0).getRate()));
        return tgt;
    }

    public static String convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        return src.toCode();
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(String src) throws FHIRException {
        if (src == null)
            return null;
        return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.fromCode(src);
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_40.convertReference(t));
        }
        return tgt;
    }
}
