package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Composition10_50 {

    public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.dstu2.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        }
        if (src.hasClass_()) {
            tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(src.getClass_()));
        }
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCompositionStatus(src.getStatus()));
        }
        try {
            if (src.hasConfidentiality()) {
                tgt.setConfidentiality(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.fromCode(src.getConfidentiality()));
            }
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        if (src.hasAuthor()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasAttester()) {
            for (org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        }
        if (src.hasCustodian()) {
            tgt.setCustodian(VersionConvertor_10_50.convertReference(src.getCustodian()));
        }
        if (src.hasEvent()) {
            for (org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition tgt = new org.hl7.fhir.dstu2.model.Composition();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        }
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_10_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertCompositionStatus(src.getStatus()));
        }
        if (src.hasConfidentiality()) {
            tgt.setConfidentiality(src.getConfidentiality().toCode());
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        }
        if (src.hasAuthor()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasAttester()) {
            for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        }
        if (src.hasCustodian()) {
            tgt.setCustodian(VersionConvertor_10_50.convertReference(src.getCustodian()));
        }
        if (src.hasEvent()) {
            for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getEncounter()));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSONAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PERSONAL;
            case PROFESSIONAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PROFESSIONAL;
            case LEGAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.LEGAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.OFFICIAL;
            default:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSONAL:
                return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PERSONAL;
            case PROFESSIONAL:
                return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PROFESSIONAL;
            case LEGAL:
                return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.LEGAL;
            case OFFICIAL:
                return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.OFFICIAL;
            default:
                return org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.addMode(convertCompositionAttestationMode(src.getMode()));
        if (src.hasTime()) {
            tgt.setTime(src.getTime());
        }
        if (src.hasParty()) {
            tgt.setParty(VersionConvertor_10_50.convertReference(src.getParty()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertCompositionAttestationMode(src.getMode().get(0).getValue()));
        if (src.hasTime()) {
            tgt.setTime(src.getTime());
        }
        if (src.hasParty()) {
            tgt.setParty(VersionConvertor_10_50.convertReference(src.getParty()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        if (src.hasDetail()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        }
        if (src.hasDetail()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.CompositionStatus convertCompositionStatus(org.hl7.fhir.dstu2.model.Composition.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.r5.model.Enumerations.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu2.model.Composition.SectionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        }
        if (src.hasText()) {
            tgt.setText(VersionConvertor_10_50.convertNarrative(src.getText()));
        }
        if (src.hasMode()) {
            tgt.setMode(src.getMode().toCode());
        }
        if (src.hasOrderedBy()) {
            tgt.setOrderedBy(VersionConvertor_10_50.convertCodeableConcept(src.getOrderedBy()));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasEmptyReason()) {
            tgt.setEmptyReason(VersionConvertor_10_50.convertCodeableConcept(src.getEmptyReason()));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu2.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        }
        if (src.hasText()) {
            tgt.setText(VersionConvertor_10_50.convertNarrative(src.getText()));
        }
        try {
            if (src.hasMode()) {
                tgt.setMode(org.hl7.fhir.r5.model.Enumerations.ListMode.fromCode(src.getMode()));
            }
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasOrderedBy()) {
            tgt.setOrderedBy(VersionConvertor_10_50.convertCodeableConcept(src.getOrderedBy()));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_50.convertReference(t));
        }
        if (src.hasEmptyReason()) {
            tgt.setEmptyReason(VersionConvertor_10_50.convertCodeableConcept(src.getEmptyReason()));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }
}
