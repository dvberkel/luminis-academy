#! /usr/bin/env perl

use strict;
use warnings;

print currentBranch();

sub currentBranch {
	my $branches = `git branch`;
	if ($branches =~ m/^\*\s(?<branch>\w+)/m) {
		return $+{'branch'};
	}
	return "";
}