class UnderscoreCodecTests extends GroovyTestCase {
  void testEncode() {
    String test = "this is a test"
    assertEquals "this_is_a_test", test.encodeAsUnderscore()
  }
  
  void testDecode() {
    String test = "this_is_a_test"
    assertEquals "this is a test", test.decodeUnderscore()
  }
}