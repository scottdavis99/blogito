class EntryTitleCodecTests extends GroovyTestCase {
  void testEncode() {
    String test = "this is a test"
    assertEquals "this_is_a_test", test.encodeAsEntryTitle()
  }
  
  void testDecode() {
    String test = "this_is_a_test"
    assertEquals "this is a test", test.decodeEntryTitle()
  }
}