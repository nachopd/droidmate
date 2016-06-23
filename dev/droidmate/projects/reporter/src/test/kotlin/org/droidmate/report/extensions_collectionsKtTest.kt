// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org
package org.droidmate.report

import org.junit.Test
import kotlin.test.assertEquals

class extensions_collectionsKtTest {

  @Test
  fun uniqueItemsWithFirstOccurrenceIndexTest() {

    val items = listOf(
      listOf(
        Pair("item1","ignored1"),
        Pair("ITEM1","ignored2"),
        Pair("item2","ignored2"),
        Pair("ITEM2","ignored3"),
        Pair("item3","ignored4")
      ),
      listOf(
        Pair("item1","ignored1"),
        Pair("ITEM2","ignored1"),
        Pair("item4","ignored3")
      ),
      listOf(
        Pair("ITEM5","ignored1"),
        Pair("item3","ignored3"),
        Pair("item4","ignored2")
      )
    
    )
    val expected = mapOf(
      Pair("ITEM1", 1),
      Pair("ITEM2", 1),
      Pair("item3", 1),
      Pair("item4", 2),
      Pair("ITEM5", 3)
    )
    
    // Act
    val actual: Map<String, Int> = items.uniqueItemsWithFirstOccurrenceIndex(
      extractItems = { it.map { it.first } }, 
      extractUniqueString = { it.toLowerCase() }
    )
    
    assertEquals(expected, actual)
  }
}
