/**
 * 
 */
package numberrangesummarizer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

/**
 * @author Sach
 *
 */
class DemoTest {

	// tests for collect method
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 */
	@Test
	void testCollectGoldenPath() {
		Demo demo = new Demo();
		Collection<Integer> expected = Arrays.asList(1, 2, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
		String input = "1,2,3,6,7,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> actual = demo.collect(input);
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 */
	@Test
	void testCollectNegativeNumbersInput() {
		Demo demo = new Demo();
		Collection<Integer> expected = Arrays.asList(-1, -2, -3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
		String input = "-1,-2,-3,6,7,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> actual = demo.collect(input);
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 */
	@Test
	void testCollectDecimalNumbersInput() {
		Demo demo = new Demo();
		Collection<Integer> expected = Arrays.asList(-1, -2, -3, 6, 7, 8, 13, 14, 15, 21, 22, 23, 24, 31);
		String input = "-1,-2,-3,6,7,8,12.4,13,14,15,21,22,23,24,31";
		Collection<Integer> actual = demo.collect(input);
		assertEquals(expected, actual);
	}
	
//		TODO(@sach): implement this test
//		/**
//		 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
//		 * null input test
//		 */
//		@Test
//		void testCollectNullInput() {
//			Demo demo = new Demo();
//			String input = null;
//			Collection<Integer> actual = demo.collect(input);
//			assertEquals("Invalid Input: null input", actual);
//		}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 * non digit test
	 */
//	 TODO(@sach): implement test for non digit characters
	@Test
	void testCollectNonNumericInput() {
		Demo demo = new Demo();
		Collection<Integer> expected = Arrays.asList(1, 2, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
		String input = "&,*, 1,2,3,6,7,@,8,12,13,14,15,21,22,23,24,31";
		Collection<Integer> actual = demo.collect(input);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 * non digit test
	 */
//	 TODO(@sach): implement test for non digit characters
	@Test
	void testCollectHangingCommaInput() {
		Demo demo = new Demo();
		Collection<Integer> expected = Arrays.asList(1, 2, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
		String input = ",,,,1,2,3,6,7,8,12,,,13,14,15,21,22,23,24,31,,,";
		Collection<Integer> actual = demo.collect(input);
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 * non digit test
	 */
//	 TODO(@sach): implement test for white spaces between numbers
//	@Test
//	void testCollectWhiteSpacesInput() {
//		Demo demo = new Demo();
//		Collection<Integer> expected = Arrays.asList(1, 2, 3, 6, 7, 8, 12, 13);
//		String input = "1,2, 3,  6,7 ,8,12  ,13,1 4,1  5, 2 1 ,  2  2  ";
//		Collection<Integer> actual = demo.collect(input);
//		assertEquals(expected, actual);
//	}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#collect(java.lang.String)}.
	 * escape characters test
	 */
//	@Test
//	void testCollectEscapeCharacters() {
//		Demo demo = new Demo();
//		Collection<Integer> expected = Arrays.asList(1, 2, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
//		String input = "\"&,*,1,2,{,|,3,\\\\,6,\\n,7,@,8,12,-,13,$,14,15,+, 21,22,),23,24,31\"";
//		Collection<Integer> actual = demo.collect(input);
//		assertEquals(expected, actual);
//	}
	
	//tests for summarizeCollection method
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 */
	@Test
	void testSummarizeCollectionGoldenPath() {
		Demo demo = new Demo();
		Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
		String expected = "1, 3, 6-8, 12-15, 21-24, 31";
		String actual = demo.summarizeCollection(input);
		assertEquals(expected, actual);
	}
	
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 */
	@Test
	void testSummarizeCollectionNegativeNumbers() {
		Demo demo = new Demo();
		Collection<Integer> input = Arrays.asList(-8,-4,-1,-2,-3,6,7,8,12,13,14,15,21,22,23,24,31);
		String expected = "-8, -4--1, 6-8, 12-15, 21-24, 31";
		String actual = demo.summarizeCollection(input);
		assertEquals(expected, actual);
	}
	
	// mono range tests
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 */	
	@Test
	void testSummarizeCollectionMonoRangePositive() {
		Demo demo = new Demo();
		Collection<Integer> input = Arrays.asList(32, 26, 42, 7, 8, 33, 25, 19, 24, 44, 49, 21, 31, 
				37, 50, 35, 6, 28, 47, 34, 27, 17, 12, 1, 41, 23, 46, 30, 2, 9, 18, 20, 40, 36, 48, 
				5, 15, 4, 39, 43, 13, 14, 10, 11, 45, 3, 38, 16, 22, 29);
		String expected = "1-50";
		String actual = demo.summarizeCollection(input);
		assertEquals(expected, actual);
	}
	
//	TODO(@sach): test monorangenegative
	
	// multi range tests
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 * //		You requested 1 sets with ?? unique random integers in each, taken from the [1-550] range. 
//		The integers in each set were sorted in ascending order.
	 */	
	@Test
	void testSummarizeCollectionMultiRangePositive() {
		Demo demo = new Demo();
		Collection<Integer> input = Arrays.asList(233, 389, 279, 254, 392, 263, 221, 301, 531,
				518, 373, 523, 177, 390, 466, 208, 136, 541, 349, 211, 158, 422, 397, 82, 260, 243,
				495, 326, 365, 112, 472, 283, 8, 352, 393, 216, 78, 460, 262, 15, 51, 284, 336, 414,
				330, 359, 245, 97, 111, 275, 17, 418, 528, 406, 398, 280, 276, 353, 90, 132, 416,
				133, 402, 110, 186, 400, 408, 470, 59, 160, 131, 514, 494, 200, 388, 249, 167, 477,
				421, 469, 109, 268, 395, 85, 440, 347, 68, 198, 426, 486, 242, 122, 151, 287, 542,
				520, 286, 316, 304, 533, 517, 487, 46, 107, 34, 501, 540, 492, 72, 125, 411, 218,
				289, 43, 42, 506, 374, 92, 1, 372, 120, 401, 412, 228, 341, 413, 127, 522, 307, 442,
				532, 547, 225, 116, 525, 95, 322, 88, 274, 299, 147, 338, 215, 25, 236, 165, 419, 23,
				327, 500, 329, 106, 361, 180, 256, 210, 202, 526, 543, 417, 294, 253, 244, 311, 175,
				318, 190, 290, 246, 130, 153, 219, 217, 195, 549, 103, 539, 124, 146, 463, 148, 231,
				451, 288, 480, 199, 515, 184, 490, 171, 546, 265, 77, 340, 76, 137, 176, 52, 447, 423,
				163, 356, 75, 223, 238, 203, 375, 105, 443, 37, 166, 22, 489, 13, 450, 333, 118, 473, 4,
				465, 334, 99, 435, 89, 164, 9, 320, 73, 119, 87, 197, 252, 483, 170, 209, 545, 530, 269,
				3, 196, 121, 27, 183, 113, 479, 507, 485, 298, 488, 270, 476, 386, 30, 277, 431, 453,
				100, 370, 155, 67, 503, 293, 544, 297, 405, 234, 379, 456, 484, 537, 69, 40, 204, 441,
				2, 302, 101, 206, 339, 438, 378, 93, 58, 384, 358, 504, 527, 396, 114, 497, 53, 387,
				98, 36, 229, 427, 115, 65, 33, 513, 91, 337, 11, 187, 357, 24, 35, 48, 66, 491, 462, 70,
				213, 436, 377, 550, 14, 428, 305, 239, 505, 258, 173, 80, 56, 194, 429, 444, 172, 502,
				50, 468, 230, 191, 430, 314, 524, 162, 259, 63, 534, 519, 117, 475, 174, 237, 79, 220,
				31, 350, 351, 235, 86, 508, 267, 247, 41, 38, 62, 457, 159, 382, 509, 135, 319, 321, 511,
				81, 309, 26, 12, 83, 226, 354, 415, 306, 315, 368, 134, 168, 227, 152, 454, 250, 94, 403,
				362, 381, 482, 521, 281, 212, 205, 74, 45, 266, 376, 178, 6, 420, 538, 498, 292, 535, 189,
				452, 344, 369, 467, 224, 264, 510, 313, 342, 261, 7, 391, 303, 461, 360, 96, 49, 29, 19,
				185, 44, 61, 449, 383, 493, 140, 285, 179, 295, 272, 366, 348, 394, 308, 169, 129, 300, 471,
				364, 363, 251, 439, 404, 141, 18, 182, 496, 16, 371, 248, 214, 346, 145, 123, 343, 5, 192,
				222, 434, 548, 157, 28, 385, 332, 143, 64, 102, 345, 273, 139, 60, 455, 448, 161, 55, 323,
				271, 536, 232, 54, 71, 126, 437, 446, 407, 478, 104, 464, 355, 108, 142, 432, 10, 278);
		String expected = "1-19, 22-31, 33-38, 40-46, 48-56, 58-83, 85-127, 129-137, 139-143, 145-148,"
				+ " 151-153, 155, 157-180, 182-187, 189-192, 194-200, 202-206, 208-239, 242-254, 256, "
				+ "258-281, 283-290, 292-295, 297-309, 311, 313-316, 318-323, 326-327, 329-330, 332-334,"
				+ " 336-366, 368-379, 381-398, 400-408, 411-423, 426-432, 434-444, 446-457, 460-473, 475-480,"
				+ " 482-498, 500-511, 513-515, 517-528, 530-550";
		String actual = demo.summarizeCollection(input);
		assertEquals(expected, actual);
	}
	
	
	// disparate ranges positive and negative test
//	TODO(@sach): implement this test
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 * //		You requested 10 sets with 100 unique random integers in each, taken from the [-1000564,3456743] range. 
//		The integers in each set were sorted in ascending order.
	 */	
//	@Test
//	void testSummarizeCollectionDisparateMultiRangePositiveNegative() {
//		Demo demo = new Demo();
//		Collection<Integer> input = Arrays.asList(-975213, -908915, -872718, -856291, -808170, -732158, -702987,
//				-638163, -620384, -615614, -615612, -615612 -607034, -568285, -562089, -438095, -360353, -162120, -141496,
//				-134892, -125011, -124029, -63572, -19018, -12010, 5299, 46476, 216457, 234671, 289405,
//				370842, 374166, 399542, 494808, 521707, 526530, 569355, 636369, 694565, 795456, 875310,
//				913074, 980211, 1018193, 1078679, 1116271, 1120071, 1127752, 1133932, 1145205, 1153523,
//				1183227, 1200483, 1203064, 1212825, 1224559, 1273210, 1298881, 1301589, 1411545, 1486057,
//				1517465, 1538706, 1545415, 1626153, 1755210, 1930254, 1940198, 1992405, 2012340, 2050364,
//				2082003, 2082742, 2091489, 2117993, 2159113, 2171572, 2205602, 2232525, 2270281, 2466219,
//				2504077, 2543091, 2628840, 2672451, 2741584, 2762084, 2833291, 2878373, 2920252, 3007322,
//				3011794, 3024757, 3097013, 3128475, 3227265, 3260312, 3292663, 3360372, 3366320, 3388425,
//				3446047);
//		String expected = "-975213, -908915, -872718, -856291, -808170, -732158, -702987, -638163, -620384,"
//				+ " -615614--615612, -607034, -568285, -562089, -438095, -360353, -162120, -141496, -134892, -125011,"
//				+ " -124029, -63572, -19018, -12010, 5299, 46476, 216457, 234671, 289405, 370842, 374166, 399542,"
//				+ " 494808, 521707, 526530, 569355, 636369, 694565, 795456, 875310, 913074, 980211, 1018193,"
//				+ " 1078679, 1116271, 1120071, 1127752, 1133932, 1145205, 1153523, 1183227, 1200483, 1203064,"
//				+ " 1212825, 1224559, 1273210, 1298881, 1301589, 1411545, 1486057, 1517465, 1538706, 1545415,"
//				+ " 1626153, 1755210, 1930254, 1940198, 1992405, 2012340, 2050364, 2082003, 2082742, 2091489,"
//				+ " 2117993, 2159113, 2171572, 2205602, 2232525, 2270281, 2466219, 2504077, 2543091, 2628840,"
//				+ " 2672451, 2741584, 2762084, 2833291, 2878373, 2920252, 3007322, 3011794, 3024757, 3097013,"
//				+ " 3128475, 3227265, 3260312, 3292663, 3360372, 3366320, 3388425, 3446047";
//		String actual = demo.summarizeCollection(input);
//		assertEquals(expected, actual);
//	}
	
	// discontinuity test
//	TODO(@sach): implement this test
	/**
	 * Test method for {@link numberrangesummarizer.Demo#summarizeCollection(java.util.Collection)}.
	 */	
//	@Test
//	void testSummarizeCollectionDiscontinuityTest() {
//		Demo demo = new Demo();
//"-8,-4,-3,-2,-1,0,1,6,7,8,12,13,14,15,21,22,23,24,31"
//		Collection<Integer> input = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
//		String expected = "-3-3";
//		String actual = demo.summarizeCollection(input);
//		assertEquals(expected, actual);
//	}
}
