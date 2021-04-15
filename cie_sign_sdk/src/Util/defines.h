#pragma once

#include "funccallinfo.h"

#define StatusWord uint16_t

#define ERR_CARD_FILE_DEACTIVATED		0x6283
#define ERR_CARD_FILE_TERMINATED		0x6285
#define ERR_CARD_AUTENTICATION_FAILED	0x6300
#define ERR_CARD_EEPROM_ERROR			0x6581
#define ERR_CARD_LC_INVALID				0x6700
#define ERR_CARD_LOGICAL_CHANNEL		0x6881
#define ERR_CARD_SM_MODE				0x6882
#define ERR_CARD_CHAINING				0x6884
#define ERR_CARD_FILE_STRUCTURE			0x6981
#define ERR_CARD_ACCESS_RIGHT			0x6982
#define ERR_CARD_BSOBJ_BLOCKED			0x6983
#define ERR_CARD_BSOBJ_FORMAT			0x6984
#define ERR_CARD_NO_RANDOM				0x6985
#define ERR_CARD_NO_CURRENT_EF			0x6986
#define ERR_CARD_NO_SM_KEY				0x6987
#define ERR_CARD_SMKEY_FORMAT			0x6988
#define ERR_CARD_INVALID_DATA_FIELD		0x6A80
#define ERR_CARD_FUNCTION_NOT_SUPPORTED	0x6A81
#define ERR_CARD_FILE_NOT_FOUND			0x6A82
#define ERR_CARD_RECORD_NOT_FOUND		0x6A83
#define ERR_CARD_NOT_ENOUGH_MEMORY		0x6A84
#define ERR_CARD_TLV_LENGTH				0x6A85
#define ERR_CARD_P1_P2_INVALID			0x6A86
#define ERR_CARD_LC_P1_P2_INVALID		0x6A87
#define ERR_CARD_OBJECT_NOT_FOUND		0x6A88
#define ERR_CARD_EF_ALREADY_EXISTS		0x6A89
#define ERR_CARD_DF_ALREADY_EXISTS		0x6A8A
#define ERR_CARD_LE_TOO_SMALL			0x6C00
#define ERR_CARD_INS_INVALID			0x6D00
#define ERR_CARD_CLA_INVALID			0x6E00
#define ERR_CARD_TECHNICAL_ERROR		0x6F00
#define ERR_CARD_LCYCLE_DEATH			0x6F01
#define ERR_CARD_FAIL_CORRUPT			0x6F02
#define ERR_CARD_CHECKSUM_ERROR			0x6F81
#define ERR_CARD_NOT_ENOUGH_XXRAM		0x6F82
#define ERR_CARD_TRANSACTION_ERROR		0x6F83
#define ERR_CARD_GENERAL_PROTECTION_FAULT	0x6F84
#define ERR_CARD_INTERNAL_FAULT			0x6F85
#define ERR_CARD_KEY_NOT_FOUND			0x6F86
#define ERR_CARD_HARDWARE_ATTACK		0x6F87
#define ERR_CARD_TRANS_BUFFER_TOO_SMALL	0x6F88
#define ERR_CARD_INTERNAL_ERROR			0x6FFF
#define CARD_OK							0x9000
#define CARD_OK_SECOND_TRIAL			0x9001
#define ERR_CARD_OVERFLOW_UNDERFLOW		0x9850

#define logParam(p)
#define logParamBuf(p,l)
#define logParamBufHide(p,l)

#define init_func \
  	CFuncCallInfo info(__FUNCTION__ ,Log);

#define exit_func

#define ER_ASSERT(a,b) \
	if (!(a)) \
		throw logged_error(stdPrintf("Eccezione nel file %s, linea %i: %s",__FILE__,__LINE__,b));
