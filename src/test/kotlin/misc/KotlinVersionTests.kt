package misc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class KotlinVersionTests {
    @Test
    internal fun `comparison of KotlinVersion instances work`() {
        val v12 = KotlinVersion(major = 1, minor = 2)
        val v1341 = KotlinVersion(1, 4, 10)
        assertAll(
            { assertTrue(v12 < KotlinVersion.CURRENT) },
            { assertTrue(v1341 <= KotlinVersion.CURRENT) },
            { assertEquals(KotlinVersion(1, 4, 10),
                KotlinVersion(major = 1, minor = 4, patch = 10)) }
        )
    }

    @Test
    internal fun `versions are Ints less than max`() {
        val max = KotlinVersion.MAX_COMPONENT_VALUE
        assertAll(
            { assertTrue(KotlinVersion.CURRENT.major < max) },
            { assertTrue(KotlinVersion.CURRENT.minor < max) },
            { assertTrue(KotlinVersion.CURRENT.patch < max) }
        )
    }

    @Test
    internal fun `check current version inside range`() {
        assertTrue(KotlinVersion.CURRENT in KotlinVersion(1,2)..KotlinVersion(1,5))
    }

    @Test
    internal fun `current version is at least 1_3`() {
        assertTrue(KotlinVersion.CURRENT.isAtLeast(major = 1, minor = 4))
        assertTrue(KotlinVersion.CURRENT.isAtLeast(major = 1, minor = 4, patch = 10))
    }

    @Test
    internal fun `left-shift values for major, minor, and patch`() {
        assertEquals(65536, 1 shl 16)
        assertEquals(768, 3 shl 8)
        assertEquals(66354, (1 shl 16) + (3 shl 8) + 50)
    }
}
