package Luminis::Academy;

use strict;
use warnings;

require Exporter;

our $VERSION = '1.00';

our @ISA = qw(Exporter);
our @EXPORT_OK = qw(createCourse createNextSteppingStone lastCommitAsSteppingStone);

sub currentBranch {
	my $branches = `git branch`;
	if ($branches =~ m/^\*\s(?<branch>\S+)/m) {
		return $+{'branch'}
	}
	return ""
}

sub findGreatestSteppingStone {
	my $branch = currentBranch();
	if ($branch) {
		my $tags = `git tag`;
		my $max = -1; my $steppingStone = "";
		while ($tags =~ /(?<steppingStone>$branch-(?<step>\d+))/gm) {
			my $step = int($+{'step'});
			if ((not $steppingStone) || $step > $max) {
				$max = $step;
				$steppingStone = $+{'steppingStone'};
			}
		}
		return $steppingStone;
	}
	return ""
}

sub nextSteppingStone {
	my $currentSteppingStone = shift(@_) || "";
	my $step = -1;
	if ($currentSteppingStone =~ /(?<step>\d+)/) {
		$step = $+{'step'};
	}
	$step++;
	return currentBranch() . "-" . $step;
}

sub createNextSteppingStone {
	my $currentSteppingStone = findGreatestSteppingStone();
	my $nextSteppingStone = nextSteppingStone($currentSteppingStone);
	system("git tag -a -m 'next step' $nextSteppingStone");
}

sub createCourse {
	my $course = shift @_;
	my $branch = shift @_;
	system("git checkout -b $course $branch");
	createNextSteppingStone();
}

sub lastCommitAsSteppingStone {
	my $branch = currentBranch();
	if ($branch) {
		if ($branch =~ m/(?<course>\w+)-/) {
			my $course = $+{'course'};
			my $logs = `git log -1`;
			if ($logs =~ m/commit (?<sha>[0-9a-zA-Z]+)/) {
				my $sha = $+{'sha'};
				system("git checkout $course");
				system("git cherry-pick $sha");
				system("git checkout $branch");
			}
		}
	}
}
