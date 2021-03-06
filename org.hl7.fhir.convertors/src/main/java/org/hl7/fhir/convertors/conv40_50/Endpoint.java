package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.convertors.VersionConvertor_40_50;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Endpoint extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Endpoint convertEndpoint(org.hl7.fhir.r4.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Endpoint tgt = new org.hl7.fhir.r5.model.Endpoint();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertEndpointStatus(src.getStatus()));
        if (src.hasConnectionType())
            tgt.setConnectionType(convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasPayloadType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(convertCodeableConcept(t));
        }
        if (src.hasPayloadMimeType()) {
            for (org.hl7.fhir.r4.model.CodeType t : src.getPayloadMimeType()) tgt.getPayloadMimeType().add(convertCode(t));
        }
        if (src.hasAddress())
            tgt.setAddressElement(convertUrl(src.getAddressElement()));
        if (src.hasHeader()) {
            for (org.hl7.fhir.r4.model.StringType t : src.getHeader()) tgt.getHeader().add(convertString(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Endpoint convertEndpoint(org.hl7.fhir.r5.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Endpoint tgt = new org.hl7.fhir.r4.model.Endpoint();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertEndpointStatus(src.getStatus()));
        if (src.hasConnectionType())
            tgt.setConnectionType(convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact()) tgt.addContact(convertContactPoint(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasPayloadType()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(convertCodeableConcept(t));
        }
        if (src.hasPayloadMimeType()) {
            for (org.hl7.fhir.r5.model.CodeType t : src.getPayloadMimeType()) tgt.getPayloadMimeType().add(convertCode(t));
        }
        if (src.hasAddress())
            tgt.setAddressElement(convertUrl(src.getAddressElement()));
        if (src.hasHeader()) {
            for (org.hl7.fhir.r5.model.StringType t : src.getHeader()) tgt.getHeader().add(convertString(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Endpoint.EndpointStatus convertEndpointStatus(org.hl7.fhir.r4.model.Endpoint.EndpointStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.SUSPENDED;
            case ERROR:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ERROR;
            case OFF:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.OFF;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ENTEREDINERROR;
            case TEST:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.TEST;
            default:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Endpoint.EndpointStatus convertEndpointStatus(org.hl7.fhir.r5.model.Endpoint.EndpointStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.SUSPENDED;
            case ERROR:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ERROR;
            case OFF:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.OFF;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.ENTEREDINERROR;
            case TEST:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.TEST;
            default:
                return org.hl7.fhir.r4.model.Endpoint.EndpointStatus.NULL;
        }
    }
}
