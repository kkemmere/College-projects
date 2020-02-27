.data
.balign 4 
	fib: 	.skip 160    @word directive allocates 40 words
	format: .asciz " %d"
	newln:	.asciz "\n"
.text
.global main
.extern printf
.extern scanf

main:
	push {ip, lr}
	ldr r6, =fib //R6 has base address of fib array
	mov r7, #2 //R7 is counter
	mov r10, #0 //R10 is fib(i-2) 
	mov r11, #1 //R11 is fib(i-1) 
	str r10, [r6, #0]
	str r11, [r6, #4]

loop:
	cmp r7, #39
	beq end

    mov r1, r7
	ldr r0, =format
	bl printf

	add r7, r7, #1
	b loop

end:
	pop {ip, pc}
