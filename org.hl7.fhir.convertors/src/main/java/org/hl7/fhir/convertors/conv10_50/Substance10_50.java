package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Substance10_50 {

    public static org.hl7.fhir.r5.model.Substance convertSubstance(org.hl7.fhir.dstu2.model.Substance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Substance tgt = new org.hl7.fhir.r5.model.Substance();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Substance convertSubstance(org.hl7.fhir.r5.model.Substance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance tgt = new org.hl7.fhir.dstu2.model.Substance();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setQuantity(VersionConvertor_10_50.convertRatio(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setQuantity(VersionConvertor_10_50.convertRatio(src.getQuantity()));
        tgt.setSubstance(VersionConvertor_10_50.convertReference(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        tgt.setExpiry(src.getExpiry());
        tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.dstu2.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        tgt.setExpiry(src.getExpiry());
        tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }
}