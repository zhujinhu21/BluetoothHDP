/*
 * Copyright 2006 Abdulla G. Abdurakhmanov (abdulla.abdurakhmanov@gmail.com).
 *
 * Licensed under the LGPL, Version 2 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/copyleft/lgpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * With any your questions welcome to my e-mail
 * or blog at http://abdulla-a.blogspot.com.
 */

package org.bn.metadata;

import java.io.InputStream;
import java.io.OutputStream;

import org.bn.annotations.*;
import org.bn.coders.DecodedObject;
import org.bn.coders.ElementInfo;
import org.bn.coders.IASN1TypesDecoder;
import org.bn.coders.IASN1TypesEncoder;

/**
 * @author jcfinley@users.sourceforge.net
 */
public class ASN1EnumItemMetadata extends ASN1FieldMetadata {

    private Class enumClass;

    public ASN1EnumItemMetadata(String name, Class enumClass)
    {
        super(name);
        this.enumClass = enumClass;
    }

    public ASN1EnumItemMetadata(ASN1EnumItem annotation, Class enumClass) {
        this(annotation.name(),enumClass);
    }

    public int encode(IASN1TypesEncoder encoder, Object object, OutputStream stream,
               ElementInfo elementInfo) throws Exception {
        return encoder.encodeEnumItem(object, enumClass, stream, elementInfo);
    }

    public DecodedObject decode(IASN1TypesDecoder decoder, DecodedObject decodedTag, Class objectClass, ElementInfo elementInfo, InputStream stream) throws Exception {
        return decoder.decodeEnumItem(decodedTag,objectClass,enumClass,elementInfo,stream);
    }

}