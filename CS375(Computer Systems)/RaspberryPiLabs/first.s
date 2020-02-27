@ first.s 
@ This is my first rasping assembly program
@
	.global main
main:	mov r0, #2  @ load immediate value 2 into register 0
	bx lr
