package org.hl7.fhir.convertors.conv30_40.resources30_40;


import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Base64Binary30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.dstu3.model.Device;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Collections;
import java.util.stream.Collectors;

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
public class Device30_40 {

  public static org.hl7.fhir.r4.model.Device convertDevice(org.hl7.fhir.dstu3.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Device tgt = new org.hl7.fhir.r4.model.Device();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasUdi()) {
      org.hl7.fhir.r4.model.Device.DeviceUdiCarrierComponent carrierComponent = tgt.getUdiCarrierFirstRep();
      carrierComponent.setDeviceIdentifierElement(String30_40.convertString(src.getUdi().getDeviceIdentifierElement()));
      carrierComponent.setJurisdictionElement(Uri30_40.convertUri(src.getUdi().getJurisdictionElement()));
      carrierComponent.setCarrierHRFElement(String30_40.convertString(src.getUdi().getCarrierHRFElement()));
      carrierComponent.setCarrierAIDCElement(Base64Binary30_40.convertBase64Binary(src.getUdi().getCarrierAIDCElement()));
      carrierComponent.setIssuerElement(Uri30_40.convertUri(src.getUdi().getIssuerElement()));
      carrierComponent.setEntryTypeElement(convertUDIEntryType(src.getUdi().getEntryTypeElement()));
      tgt.setUdiCarrier(Collections.singletonList(carrierComponent));
      org.hl7.fhir.r4.model.Device.DeviceDeviceNameComponent nameComponent = tgt.getDeviceNameFirstRep();
      nameComponent.setNameElement(String30_40.convertString(src.getUdi().getNameElement()));
      nameComponent.setType(org.hl7.fhir.r4.model.Device.DeviceNameType.UDILABELNAME);
    }
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String30_40.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime30_40.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
    if (src.hasModelElement())
      tgt.setModelNumberElement(String30_40.convertString(src.getModelElement()));
    if (src.hasVersionElement())
      tgt.setVersion(Collections.singletonList(tgt.getVersionFirstRep().setValueElement(String30_40.convertString(src.getVersionElement()))));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(Reference30_40.convertReference(src.getOwner()));
    if (src.hasContact())
      tgt.setContact(src.getContact().stream().map(ContactPoint30_40::convertContactPoint).collect(Collectors.toList()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept30_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Device convertDevice(org.hl7.fhir.r4.model.Device src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Device tgt = new org.hl7.fhir.dstu3.model.Device();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasUdiCarrier()) {
      Device.DeviceUdiComponent udi = tgt.getUdi();
      udi.setDeviceIdentifierElement(String30_40.convertString(src.getUdiCarrierFirstRep().getDeviceIdentifierElement()));
      udi.setJurisdictionElement(Uri30_40.convertUri(src.getUdiCarrierFirstRep().getJurisdictionElement()));
      udi.setCarrierHRFElement(String30_40.convertString(src.getUdiCarrierFirstRep().getCarrierHRFElement()));
      udi.setCarrierAIDCElement(Base64Binary30_40.convertBase64Binary(src.getUdiCarrierFirstRep().getCarrierAIDCElement()));
      udi.setIssuerElement(Uri30_40.convertUri(src.getUdiCarrierFirstRep().getIssuerElement()));
      udi.setEntryTypeElement(convertUDIEntryType(src.getUdiCarrierFirstRep().getEntryTypeElement()));
      tgt.setUdi(udi);
    }
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRDeviceStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String30_40.convertString(src.getLotNumberElement()));
    if (src.hasManufacturer())
      tgt.setManufacturerElement(String30_40.convertString(src.getManufacturerElement()));
    if (src.hasManufactureDate())
      tgt.setManufactureDateElement(DateTime30_40.convertDateTime(src.getManufactureDateElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime30_40.convertDateTime(src.getExpirationDateElement()));
    if (src.hasModelNumber())
      tgt.setModel(src.getModelNumber());
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersion().get(0).getValueElement()));
    if (src.hasDeviceName())
      tgt.setUdi(tgt.getUdi().setName(src.getDeviceName().get(0).getName()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasOwner())
      tgt.setOwner(Reference30_40.convertReference(src.getOwner()));
    if (src.hasContact())
      tgt.setContact(src.getContact().stream().map(ContactPoint30_40::convertContactPoint).collect(Collectors.toList()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint30_40.convertContactPoint(t));
    if (src.hasLocation())
      tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSafety())
      tgt.addSafety(CodeableConcept30_40.convertCodeableConcept(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.FHIRDeviceStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> convertFHIRDeviceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.FHIRDeviceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Device.UDIEntryTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> convertUDIEntryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Device.UDIEntryType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.UDIEntryType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Device.UDIEntryTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case BARCODE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.BARCODE);
        break;
      case RFID:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.RFID);
        break;
      case MANUAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.MANUAL);
        break;
      case CARD:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.CARD);
        break;
      case SELFREPORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.SELFREPORTED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Device.UDIEntryType.NULL);
        break;
    }
    return tgt;
  }
}