package com.cooltee.util

import org.junit.Test
import org.springframework.test.context.ContextConfiguration

/**
 * test of PropertyReader
 * Created by Daniel on 2017/5/9.
 */
class PropertyReaderTest {
    @Test
    fun getProperty() {
        val filename = "param.properties"
        val key = "key"
        val value = PropertyReader.getProperty(filename, key)
        assert(value == "value")
    }

}