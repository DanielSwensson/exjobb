.SUFFIXES: .erl .beam .yrl 

MODS := $(wildcard *.erl)

%.beam: %.erl
	erlc -W $<

ERL = erl -boot start_clean

build: beams


test: beams 
	${ERL} -pa / -s checkstyle test

oop1: beams
	${ERL} -pa / -s checkstyle oop1

oop2: beams
	${ERL} -pa / -s checkstyle oop2

alda: beams
	${ERL} -pa / -s checkstyle alda

clean: 
	rm -rf *.beam *.html *.dump



beams: ${MODS:%.erl=%.beam}

