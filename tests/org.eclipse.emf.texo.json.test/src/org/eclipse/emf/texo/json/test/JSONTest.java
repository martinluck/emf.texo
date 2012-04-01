/**
 * <copyright>
 *
 * Copyright (c) 2009, 2010 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: XMLTest.java,v 1.16 2011/08/25 12:42:34 mtaal Exp $
 */

package org.eclipse.emf.texo.json.test;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.texo.ComponentProvider;
import org.eclipse.emf.texo.json.JSONModelConverter;
import org.eclipse.emf.texo.json.ModelJSONConverter;
import org.eclipse.emf.texo.model.ModelObject;
import org.eclipse.emf.texo.server.store.MemoryObjectStore;
import org.eclipse.emf.texo.test.TestUtils;
import org.eclipse.emf.texo.xml.EMFModelConverter;
import org.json.JSONObject;
import org.junit.Assert;

/**
 * Test the conversion to and from JSON. For each test the following steps are done:
 * <ol>
 * <li>Generate test data set</li>
 * <li>Convert the test data set to json (json1)</li>
 * <li>Convert the json back to a {@link ModelObject} instance</li>
 * <li>Convert this list back to json (json22)</li>
 * <li>then the following should be true: json1.equals(json2)</li>
 * </ol>
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.16 $
 */
public class JSONTest extends BaseJSONTest {

  public void runTest() throws Exception {
    final MemoryObjectStore memObjectStore = ComponentProvider.getInstance().newInstance(MemoryObjectStore.class);

    final List<EObject> eObjects = TestUtils.generateTestSet(1, 3, 3, 10000, getEPackages(), getEClasses());
    final EMFModelConverter emfModelConverter = new EMFModelConverter();
    emfModelConverter.setUriResolver(memObjectStore);
    final Object m1 = emfModelConverter.convert(eObjects).get(0);
    memObjectStore.addData(emfModelConverter.getAllConvertedObjects());

    final ModelJSONConverter toJsonConverter = ComponentProvider.getInstance().newInstance(ModelJSONConverter.class);
    toJsonConverter.setUriResolver(memObjectStore);
    final JSONModelConverter fromJsonConverter = ComponentProvider.getInstance().newInstance(JSONModelConverter.class);
    fromJsonConverter.setUriResolver(memObjectStore);

    final JSONObject json1 = toJsonConverter.convert(m1);
    final Object m2 = fromJsonConverter.convert(json1);
    final JSONObject json2 = toJsonConverter.convert(m2);

    // System.err.println(json1);
    // System.err.println("---------------------------------------------");
    // System.err.println(json2);

    Assert.assertEquals(json1.toString(), json2.toString());

    final Object m3 = fromJsonConverter.convert(json2);
    final JSONObject json3 = toJsonConverter.convert(m3);

    Assert.assertEquals(json2.toString(), json3.toString());
  }
}