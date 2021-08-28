package com.github.xhrg.spring.note;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.xhrg.spring.note.helper.tree.LineTree;

@SpringBootApplication
public class SpringExtNoteApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringExtNoteApplication.class, args);
		LineTree.printTreeNode();
		System.exit(1);
	}
}
