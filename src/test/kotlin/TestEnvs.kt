import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class Test {
    @Test
    fun env() {
        val hostEnv = System.getenv("HOST")
        val portEnv = System.getenv("PORT")

        println("HOST: $hostEnv")
        println("PORT: $portEnv")
        assertFalse(hostEnv == null)
        assertFalse(portEnv == null)
    }

    @Test
    fun hostEnv() {
        val hostEnv = System.getenv("HOST")
        assertTrue {
            hostEnv.toString().javaClass == String::class.java
        }
    }

    @Test
    fun portEnv() {
        val portEnv = System.getenv("PORT")
        assertTrue {
            portEnv.toInt().javaClass == Int::class.java
        }
    }
}