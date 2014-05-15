.SUFFIXES: .erl .beam .yrl 

MODS := $(wildcard *.erl)

%.beam: %.erl
	erlc -W $<

ERL = erl -boot start_clean

build: beams


test: beams 
	${ERL} -pa / -s run test

oop1: beams
	${ERL} -pa / -s run oop1

oop2: beams
	${ERL} -pa / -s run oop2

alda: beams
	${ERL} -pa / -s run alda

prog21: beams
	${ERL} -pa / -s run prog21

clean: 
	rm -rf *.beam *.html *.dump



beams: ${MODS:%.erl=%.beam}

